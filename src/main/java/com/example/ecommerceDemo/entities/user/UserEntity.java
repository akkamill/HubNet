package com.example.ecommerceDemo.entities.user;

import com.example.ecommerceDemo.entities.app.*;
import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.entities.blog.CommentEntity;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import com.example.ecommerceDemo.entities.eCommerce.OrderEntity;
import com.example.ecommerceDemo.entities.eCommerce.ProductEntity;
import com.example.ecommerceDemo.entities.eCommerce.ShippingAddress;
import com.example.ecommerceDemo.entities.home.AppPurchaseEntity;
import com.example.ecommerceDemo.entities.others.PaymentEntity;
import com.example.ecommerceDemo.entities.user.enums.UserStatus;
import com.example.ecommerceDemo.entities.user.page.*;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserEntity implements org.springframework.security.core.userdetails.UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String lastName;
    private String emailAddress;
    private String password;

    private UserStatus userStatus;

    @CreationTimestamp
    private LocalDateTime userCreatedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserDetails userDetails;

    @ManyToMany
    @JoinTable(
    name = "user_bans",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "banned_user_id")
    )
    private List<UserEntity> bannedUsers = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private PremiumAccount premiumAccount;

    // -------------------------------------------------Security-----------------------------------------------------//
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return roles or authorities
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return emailAddress;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//  -----------------------------------------------------------------------------------------------------------------//

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddresses;

    @OneToMany(mappedBy = "productUser", cascade = CascadeType.ALL)
    private List<ProductEntity> products;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LikeEntity> likes;

    @OneToMany(mappedBy = "taskCommentUser", cascade = CascadeType.ALL)
    private List<TaskCommentEntity> taskComments;

    @OneToMany(mappedBy = "senderEmail", cascade = CascadeType.ALL)
    private List<EmailEntity> senderEmail;

    @OneToMany(mappedBy = "senderChat", cascade = CascadeType.ALL)
    private List<ChatEntity> senderChat;

    @OneToOne(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private AppPurchaseEntity appPurchaseEntity;

    @OneToMany(mappedBy = "userPayment")
    private List<PaymentEntity> payments;

    @OneToMany(mappedBy = "userEntity")
    private List<BlogEntity> blogs;

    @OneToMany(mappedBy = "userEntity")
    private List<CommentEntity> blogComments;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;

    @OneToMany(mappedBy = "user")
    private List<EventEntity> events;

    @OneToMany(mappedBy = "user")
    private List<SectionEntity> sections;

    @OneToMany(mappedBy = "user")
    private List<UserPostEntity> userPosts;

    @OneToMany(mappedBy = "user")
    private List<UserCommentEntity> userComments;

    @OneToMany(mappedBy = "user")
    private List<UserLikeEntity> userLikes;

    @OneToMany(mappedBy = "user")
    private List<FollowerEntity> followers;

    @OneToMany(mappedBy = "user")
    private List<FollowingEntity> followings;

    @OneToMany(mappedBy = "user")
    private List<GalleryEntity> galleryItems;

    @OneToMany(mappedBy = "user")
    private List<FriendEntity> friends;

    @OneToMany(mappedBy = "user")
    private List<AlbumEntity> albums;

}
