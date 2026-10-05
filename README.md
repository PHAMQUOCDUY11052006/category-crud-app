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

## Truoc khi chay - CAN LAM

1. **Thay anh dai dien**: thay file
   `src/main/resources/static/images/avatar.jpg` bang anh that cua ban (giu nguyen ten file
   hoac sua lai duong dan trong `templates/admin/fragments/header.html`).

2. **Sua thong tin sinh vien o footer**: mo file
   `src/main/resources/templates/admin/fragments/footer.html`, thay cac cho `[Ho va Ten]`,
   `[MSSV]`, `[Lop hoc phan]` bang thong tin that cua ban.

3. **Tao database trong SQL Server (bang SSMS)**: Khac voi MySQL, SQL Server KHONG tu tao
   database. Ban can tu tao database va bat SQL Server Authentication truoc:

   a) **Bat SQL Server Authentication (Mixed Mode)** - neu may ban dang chi dung Windows
      Authentication:
      - Mo SSMS, ket noi vao server (thuong la `localhost` hoac `.`).
      - Chuot phai vao ten server (tren cung cay Object Explorer) > **Properties**.
      - Vao muc **Security** > chon **SQL Server and Windows Authentication mode** > OK.
      - Mo **Services** (go `services.msc` trong Run) > tim **SQL Server (MSSQLSERVER)**
        > chuot phai > **Restart** de ap dung thay doi.

   b) **Bat tai khoan `sa` va dat mat khau**:
      - Trong SSMS, mo **Security** > **Logins** > chuot phai vao **sa** > **Properties**.
      - Tab **General**: dat mat khau moi (nho mat khau nay).
      - Tab **Status**: o muc Login, chon **Enabled** > OK.

   c) **Tao database**:
      - Chuot phai vao **Databases** > **New Database...**
      - Dat ten database la `category_db` > OK.
      (Khong can tao bang `categories`, Hibernate se tu tao nho `ddl-auto=update`.)

   d) **Cap nhat mat khau vao project**: mo
      `src/main/resources/application.properties`, sua dong:

      ```properties
      spring.datasource.password=YOUR_SA_PASSWORD
      ```

      thanh dung mat khau `sa` ban vua dat o buoc (b).

   > Neu SQL Server cua ban chay o cong khac 1433, hoac dung SQL Server Express (instance
   > ten `SQLEXPRESS`), sua lai URL trong `application.properties`, vi du:
   > `jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=category_db;encrypt=false;trustServerCertificate=true`

## Cach chay

### Cach 1: Dung IDE (Eclipse / Spring Tool Suite / IntelliJ)

1. Import project dang **Existing Maven Project**.
2. Doi Maven tai dependency xong (co ket noi Internet).
3. Chay class `CategoryCrudAppApplication.java` (Run As > Spring Boot App / Java Application).

### Cach 2: Dung dong lenh (co cai Maven)

```bash
mvn spring-boot:run
```

Sau khi chay, mo trinh duyet va truy cap:

```
http://localhost:8088/
```

(se tu dong chuyen huong toi `http://localhost:8088/admin/categories/searchpaginated`)

## Chuc nang da lam

- [x] Them moi Category (`GET/POST /admin/categories/add`, `/saveOrUpdate`)
- [x] Sua Category (`GET /admin/categories/edit/{id}`)
- [x] Xoa Category (`GET /admin/categories/delete/{id}`)
- [x] Tim kiem theo ten (`GET /admin/categories/searchpaginated?name=...`)
- [x] Phan trang (`?page=1&size=5`)
- [x] Layout dung chung: header (co anh), content, footer (thong tin sinh vien) -
      dung Thymeleaf Layout Dialect (`layout:decorate`, `layout:fragment`)
- [x] Validate du lieu dau vao (`@Valid`, `@NotBlank`)

## Huong dan dua len GitHub

Mo Terminal/Command Prompt tai thu muc goc cua project (noi chua file `pom.xml`) va chay:

```bash
git init
git add .
git commit -m "Bai tap ca nhan: CRUD + phan trang Category voi Thymeleaf"
git branch -M main
git remote add origin https://github.com/<ten-github-cua-ban>/<ten-repo>.git
git push -u origin main
```

> Luu y: tao repo rong (khong tick "Add README") tren GitHub truoc, roi copy URL vao lenh
> `git remote add origin ...` o tren.

Sau khi push xong, copy link repo GitHub va nop vao UTExLMS theo yeu cau de bai.
