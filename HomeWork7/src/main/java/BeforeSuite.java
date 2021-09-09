import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// аннотация доступна в режиме RUNTIME
@Retention(RetentionPolicy.RUNTIME)

// данная аннотация применяется к (методу)
@Target({ElementType.METHOD})

// выполняется в самом начале
public @interface BeforeSuite {

}
