package pedro.costa.TaskManagerAPI.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.regex.Pattern;
@Entity
@Table(name = "Users")
public class UserEntitie extends BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday ;
    private String login  ;
    private String password ;
    private String email ;

    public UserEntitie(Long id, String name, String description, Date createdAt) {
        super( name, description);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public void validate() {
        super.validate();
        if (birthday == null) {
            throw new IllegalArgumentException("Birthday cannot be null");
        }

        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Login cannot be null or empty");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email is not in a valid format");
        }
    }

    // Método auxiliar para validar o formato do e-mail
    private boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
}
