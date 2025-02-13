package de.thws.fiw.gymmanagement.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String membershipType;

    public void setName(String name) {
        this.name = name;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    // Builder Pattern for Member
    public static class Builder {
        private Long id; // Optional, usually null for new Members.
        private String name;
        private String membershipType;

        public Builder() {}

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withMembershipType(String membershipType) {
            this.membershipType = membershipType;
            return this;
        }

        public Member build() {
            Member member = new Member();
            member.id = this.id;  // This is usually null for new courses
            member.name = this.name;
            member.membershipType = this.membershipType;
            return member;
        }
    }
}
