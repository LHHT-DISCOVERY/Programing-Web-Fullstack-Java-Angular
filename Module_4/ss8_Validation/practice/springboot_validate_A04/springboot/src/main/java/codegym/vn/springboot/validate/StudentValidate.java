package codegym.vn.springboot.validate;

import codegym.vn.springboot.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
// custom validate Student
public class StudentValidate implements Validator {
//    mục đích để có Suppor classs đó hay koo (vd validate student mà đem đi validate class name là ko đc )
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

//    phương thức validate : có 2 tham số : Object , Errors
//    Errors : hứng lỗi
//    Object : đối tượng cần validate (trường hợp này là Student)
    @Override
    public void validate(Object target, Errors errors) {
//         để oan toàn nên sử dụng 1 câu lệnh if
//         nếu ko là student thì ko trả về lỗi , trả về return
        if (!(target instanceof Student)) {
            return;
        }
        Student student = (Student) target;
//        validate số điện thoại nên get trường số điện thoại ra để validate
//        rejectValue : bắn về cái lỗi (field , errorCode , đối số , defaultMessage)
//        field : trường gây ra lỗi , bắn đúng trường gây ra lỗi. vd mà để name thì trường name sẽ hiển thị lỗi của Phone => ko đúng
//        errorCode : ở bên message properties ,  new String[]{"10"} để tạo đối số bên  message properties {0}
//        defaultMessage : trường hợp nếu errorCode ko tồn tại  , sẽ hiện thị lỗi defaultMessage
        if (student.getPhoneNumber().length() != 10) {
            errors.rejectValue("phoneNumber", "phonenumber", new String[]{"10"}, "Số điện thoại không đúng định dạng");
        } else if (!student.getPhoneNumber().startsWith("0")) {
            errors.rejectValue("phoneNumber", "phonenumberstart", "Số điện thoại không đúng định dạng");
        }
    }
//     đã xây dựng xong , muốn dùng ta sẽ quay lại StudentController : 83
//    => ta thấy là :  những gì annotation ko bắt được thì qua đây ta custom và bắt đc hết
}
