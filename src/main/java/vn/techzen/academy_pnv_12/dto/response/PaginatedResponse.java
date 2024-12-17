package vn.techzen.academy_pnv_12.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginatedResponse<T> {
    List<T> content;
    PageCustom<T> page;
    public PaginatedResponse(Page<T> page) {
        content = page.getContent();
        this.page = new PageCustom<T>(page);
    }
}
