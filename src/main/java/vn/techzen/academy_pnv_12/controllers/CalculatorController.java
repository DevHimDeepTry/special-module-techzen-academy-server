package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.academy_pnv_12.dto.exception.AppException;
import vn.techzen.academy_pnv_12.dto.exception.ErrorCode;
import vn.techzen.academy_pnv_12.dto.response.ApiResponse;
import vn.techzen.academy_pnv_12.models.Operator;

@RestController
@RequestMapping("api/v1/calculators")
public class CalculatorController {

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<String>> calculate(
            @RequestParam(required = false) String firstNumber,
            @RequestParam(required = false) String secondNumber,
            @RequestParam(required = false) String operator
    ) {
        if (firstNumber == null || firstNumber.isEmpty()) {
            throw new AppException(ErrorCode.MISSING_PARAMETER);
        }

        if (secondNumber == null || secondNumber.isEmpty()) {
            throw new AppException(ErrorCode.MISSING_PARAMETER);
        }

        Double number1, number2;
        try {
            number1 = Double.parseDouble(firstNumber);
            number2 = Double.parseDouble(secondNumber);
        } catch (NumberFormatException e) {
            throw new AppException(ErrorCode.INVALID_PARAMETER);
        }

        Operator op;
        try {
            op = Operator.fromSymbol(operator);
        } catch (IllegalArgumentException e) {
            throw new AppException(ErrorCode.INVALID_PARAMETER);
        }

        Double result = performCalculation(number1, number2, op);

        return ResponseEntity.ok(
                ApiResponse.<String>builder()
                        .message("Calculation successful")
                        .data(String.valueOf(result))
                        .build()
        );
    }

    private Double performCalculation(Double number1, Double number2, Operator op) {
        switch (op) {
            case ADD:
                return number1 + number2;
            case SUBTRACT:
                return number1 - number2;
            case MULTIPLY:
                return number1 * number2;
            case DIVIDE:
                if (number2 == 0) {
                    throw new AppException(ErrorCode.DIVIDE_BY_ZERO);
                }
                return number1 / number2;
            default:
                throw new AppException(ErrorCode.INVALID_PARAMETER);
        }
    }
}
