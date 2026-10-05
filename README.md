# Category CRUD App - Spring Boot + Thymeleaf

Bai tap ca nhan mon Lap trinh Web (WEBPR330479) - CRUD va tim kiem phan trang cho
chuc nang **Category**, su dung **Thymeleaf** + **Thymeleaf Layout Dialect** lam view/layout.

## Cong nghe su dung

- Java 17, Spring Boot 3.3.4
- Spring Web MVC, Spring Data JPA, Hibernate
- Thymeleaf + thymeleaf-layout-dialect
- SQL Server (mssql-jdbc)
- Bootstrap 5 (CDN), Font Awesome (CDN)

## Cau truc project (3 lop kien truc)

```
Entity (CategoryEntity)
  -> Repository (CategoryRepository)
  -> Service (ICategoryService / CategoryServiceImpl)
  -> Controller (CategoryController - admin/categories)
  -> View (Thymeleaf - admin/layout-admin.html + fragments header/footer + categories/*.html)
```

## Chuc nang da lam

- [x] Them moi Category (`GET/POST /admin/categories/add`, `/saveOrUpdate`)
- [x] Sua Category (`GET /admin/categories/edit/{id}`)
- [x] Xoa Category (`GET /admin/categories/delete/{id}`)
- [x] Tim kiem theo ten (`GET /admin/categories/searchpaginated?name=...`)
- [x] Phan trang (`?page=1&size=5`)
- [x] Layout dung chung: header (co anh), content, footer (thong tin sinh vien) -
      dung Thymeleaf Layout Dialect (`layout:decorate`, `layout:fragment`)
- [x] Validate du lieu dau vao (`@Valid`, `@NotBlank`)
