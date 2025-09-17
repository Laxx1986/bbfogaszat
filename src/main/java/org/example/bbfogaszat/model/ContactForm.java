package org.example.bbfogaszat.model;

import jakarta.annotation.Generated;
import java.util.Objects;

@Generated("manual")
public class ContactForm {
    private String name;
    private String email;
    private String phone;
    private String subject;
    private String message;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactForm)) return false;
        ContactForm other = (ContactForm) o;
        return Objects.equals(name, other.name) &&
                Objects.equals(email, other.email) &&
                Objects.equals(phone, other.phone) &&
                Objects.equals(subject, other.subject) &&
                Objects.equals(message, other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phone, subject, message);
    }

    @Override
    public String toString() {
        return "ContactForm(name=" + name +
                ", email=" + email +
                ", phone=" + phone +
                ", subject=" + subject +
                ", message=" + message + ")";
    }
}
