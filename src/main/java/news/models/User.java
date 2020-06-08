package news.models;


import javax.persistence.*;
import java.util.Set;

@Table
@Entity
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String ip;
    private Role Role;

    private Set<News> news;

    @OneToMany
    @JoinColumn(name = "news_id")
    public Set<News> getNews() {
        return news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "ip_address")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }
}
