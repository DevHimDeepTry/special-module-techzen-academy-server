package vn.techzen.academy_pnv_12.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.techzen.academy_pnv_12.dto.request.DictionaryRequestDTO;
import vn.techzen.academy_pnv_12.dto.response.ResponseData;

import java.util.Map;

@RestController
@RequestMapping("api/v1/dictionaries")
public class DictionaryController {

    @Tag(name = "Exercise")
    @GetMapping(value = "/", headers = "apiKey=v1.0")
    public ResponseData<String> dictionary(@Valid @RequestParam DictionaryRequestDTO requestDTO){

            String word = requestDTO.getWord().trim().toLowerCase();
            String translationWord = dictionary.get(word);
            if (translationWord == null) {
                return new ResponseData<>(HttpStatus.NOT_FOUND.value(), "Khong tim thay tu nay trong tu dien", word);
            }
            return new ResponseData<>(HttpStatus.OK.value(), "Translation Successfully", translationWord);

    };

    private final Map<String, String> dictionary = Map.ofEntries(
            Map.entry("hello","Xin chao"),
            Map.entry("goodbye", "Tam Biet")
    );
}
