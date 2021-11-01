package project.todoapp.entities.concretes;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TodoItems")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TodoItemId")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "Title")
    private String title;

    @NotNull
    @Column(name = "IsDone")
    private boolean isDone = false;

    @ManyToOne()
    @JoinColumn(name = "UserId")
    private User user;
}
