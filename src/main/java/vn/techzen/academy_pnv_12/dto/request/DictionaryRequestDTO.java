package vn.techzen.academy_pnv_12.dto.request;

import jakarta.validation.constraints.*;

import java.io.Serializable;

public class DictionaryRequestDTO implements Serializable {

    @NotBlank(message = "Word must be not blank")
    private final String word;

    public DictionaryRequestDTO(String word) {
        this.word = word;
    }
    public String getWord() {
        return word;
    }
}
