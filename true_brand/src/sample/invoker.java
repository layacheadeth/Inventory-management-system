package sample;
//this invoker is the one(ex.remote that invoke command to execute certain action and act upon receiver(light)) that invokes the command to execute certain action and act upon
//receivers.
public class invoker {
    //invoker need all the command in hands.
    command registration;
    command product_sold;
    command student_grade_register;
    command student_grade_info;


    // then it set the command so that it will be ready when called.
    public void setRegistration(command registration) {
        this.registration = registration;
    }

    public void setProduct_sold(command product_sold) {
        this.product_sold = product_sold;
    }

    public void setStudent_grade_register(command student_grade_register) {
        this.student_grade_register = student_grade_register;
    }

    public void setStudent_grade_info(command student_grade_info) {
        this.student_grade_info = student_grade_info;
    }
    //when the button is pressed ,invoker invokes the command, command execute accordingly.
    public void registrationpressed(){
        registration.execute();
    }
    public void product_soldpressed(){
        product_sold.execute();
    }
    public void student_grade_registeronpressed(){
        student_grade_register.execute();
    }
    public void student_grade_infoonpressed(){
        student_grade_info.execute();
    }

}
