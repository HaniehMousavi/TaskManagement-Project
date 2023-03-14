package com.example.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task", schema = "task_management")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    @Column(name = "title")
    private String title;

    @Nationalized
    @Column(name = "description")
    private String description;

    @Nationalized
    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    private TaskStatus taskStatus = TaskStatus.PENDING;

    public Task(String title, String description, String comment, TaskStatus taskStatus, User user) {
        this.title = title;
        this.description = description;
        this.comment = comment;
        this.taskStatus = taskStatus;
        this.user = user;
    }


    public enum TaskStatus {
        PENDING,
        DOING,
        FINISHED
    }

    @ManyToOne()
    private User user;

    @ManyToOne()
    private Category category;

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_task", schema = "task_management",
//            joinColumns = @JoinColumn(name = "task_id"),
//            inverseJoinColumns = @JoinColumn(name = "users_id"))
//    private Set<User> user = new HashSet<>();

}
