package fr.auctionplus.app.bo;

import jakarta.persistence.*;

import java.security.MessageDigest;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "dbo", catalog = "BDD_AUCTIONS")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "is_admin")
    private boolean isAdmin;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (isAdmin != user.isAdmin) return false;
        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!Objects.equals(email, user.email)) return false;

        return true;
    }

    public static String hashPwd(String motDePasse)
    {
        MessageDigest md;
        byte[] hash=null;
        StringBuilder sb=null;
        try {
            md=MessageDigest.getInstance("SHA");
            md.update(motDePasse.getBytes());
            hash=md.digest();
            sb=new StringBuilder();
            for(int i=0;i<hash.length;i++)
            {
                sb.append(Integer.toHexString((hash[i]&0xff)+0x100).substring(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

}
