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

import java.util.Map;

@RestController
@RequestMapping("api/v1/dictionaries")
public class DictionaryController {

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseEntity<ApiResponse<String>> dictionary(@RequestParam(defaultValue = "") String word) {
        word = word.trim().toLowerCase();
        String translationWord = dictionary.get(word);

        if (translationWord == null) {
            throw new AppException(ErrorCode.WORD_NOT_EXIST);
        }

        return ResponseEntity.ok(
                ApiResponse.<String>builder()
                        .message("Dịch thành công")
                        .data(translationWord)
                        .build()
        );
    }

    private final Map<String, String> dictionary = Map.ofEntries(
            Map.entry("hello", "Xin chào"),
            Map.entry("love", "I Love You")
    );
}