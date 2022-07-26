/*
 * This file is generated by jOOQ.
 */
package test.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private String courseId;
    private String description;
    private String title;

    public Course() {}

    public Course(Course value) {
        this.courseId = value.courseId;
        this.description = value.description;
        this.title = value.title;
    }

    public Course(
        String courseId,
        String description,
        String title
    ) {
        this.courseId = courseId;
        this.description = description;
        this.title = title;
    }

    /**
     * Getter for <code>users.course.course_id</code>.
     */
    public String getCourseId() {
        return this.courseId;
    }

    /**
     * Setter for <code>users.course.course_id</code>.
     */
    public Course setCourseId(String courseId) {
        this.courseId = courseId;
        return this;
    }

    /**
     * Getter for <code>users.course.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>users.course.description</code>.
     */
    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Getter for <code>users.course.title</code>.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter for <code>users.course.title</code>.
     */
    public Course setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Course other = (Course) obj;
        if (courseId == null) {
            if (other.courseId != null)
                return false;
        }
        else if (!courseId.equals(other.courseId))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        }
        else if (!description.equals(other.description))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.courseId == null) ? 0 : this.courseId.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Course (");

        sb.append(courseId);
        sb.append(", ").append(description);
        sb.append(", ").append(title);

        sb.append(")");
        return sb.toString();
    }
}
