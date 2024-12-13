package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.academy_pnv_12.dto.response.ResponseData;
import vn.techzen.academy_pnv_12.models.Operator;

@RestController
@RequestMapping("api/v1/calculators")
public class CalculatorController {

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseData<String> calculate(
            @RequestParam(required = false) String firstNumber,
            @RequestParam(required = false) String secondNumber,
            @RequestParam(required = false) String operator
    ) {
        if (firstNumber == null || firstNumber.isEmpty()) {
            String message = "Tham số 'firstNumber' không được phép null.";
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), message, message);
        } else if (secondNumber == null || secondNumber.isEmpty()) {
            String message = "Tham số 'secondNumber' không được phép null.";
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), message, message);
        }

        Double number1, number2;
        try {
            number1 = Double.parseDouble(firstNumber);
            number2 = Double.parseDouble(secondNumber);
        } catch (NumberFormatException e) {
            String message = "Các tham số 'firstNumber' và 'secondNumber' phải là các giá trị số hợp lệ.";
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), message, message);
        }

        Double result = null;

        try {
            Operator op = Operator.fromSymbol(operator);

            switch (op) {
                case ADD:
                    result = number1 + number2;
                    break;
                case SUBTRACT:
                    result = number1 - number2;
                    break;
                case MULTIPLY:
                    result = number1 * number2;
                    break;
                case DIVIDE:
                    if (number2 == 0) {
                        String message = "Không được phép chia cho số không";
                        return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), message, message);
                    }
                    result = number1 / number2;
                    break;
                default:
                    return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), "Toán tử không hợp lệ", null);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseData<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
        }

        return new ResponseData<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), String.valueOf(result));
    }
}