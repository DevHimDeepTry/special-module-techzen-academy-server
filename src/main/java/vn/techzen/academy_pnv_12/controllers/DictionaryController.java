package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.academy_pnv_12.dto.response.ResponseData;

import java.util.Map;

@RestController
@RequestMapping("api/v1/dictionaries")
public class DictionaryController {

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseData<String> dictionary(@RequestParam(defaultValue = "") String word) {

        word = word.trim().toLowerCase();
        String translationWord = dictionary.get(word);
        if (translationWord == null) {
            String message = "Không tìm thấy từ này trong từ điển";
            return new ResponseData<>(HttpStatus.NOT_FOUND.value(), message, message);
        }
        return new ResponseData<>(HttpStatus.OK.value(), "Dịch thành công", translationWord);
    }

    private final Map<String, String> dictionary = Map.ofEntries(
            Map.entry("hello", "Xin chào"),
            Map.entry("goodbye", "Tạm biệt")
    );
}