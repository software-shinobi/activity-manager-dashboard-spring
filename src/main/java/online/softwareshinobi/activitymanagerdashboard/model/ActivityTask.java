package online.softwareshinobi.activitymanagerdashboard.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "activities")
public class ActivityTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    @Column(name = "date")
    String date;

    @NonNull
    @Column(name = "project")
    String project;

    @NonNull
    @Column(name = "category")
    String category;
    
    @NonNull
    @Column(name = "description")
    String description;

    @NonNull
    @Column(name = "status")
    String status;

}