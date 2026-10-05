package vn.iotstar.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryModel {

    private Long categoryId;

    @NotBlank(message = "Ten danh muc khong duoc de trong!")
    @Size(max = 200, message = "Ten danh muc toi da 200 ky tu!")
    private String name;

    // true: dang o che do sua, false: dang o che do them moi
    // Luu y: dat ten field la "edit" (khong phai "isEdit") de Lombok sinh ra
    // getter isEdit() / setter setEdit(boolean) mot cach nhat quan, tranh loi
    // binding voi Thymeleaf th:field="*{edit}"
    private boolean edit;
}
