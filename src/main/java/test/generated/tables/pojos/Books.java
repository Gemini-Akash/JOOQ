/*
 * This file is generated by jOOQ.
 */
package test.generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String  name;
    private Integer studentId;

    public Books() {}

    public Books(Books value) {
        this.id = value.id;
        this.name = value.name;
        this.studentId = value.studentId;
    }

    public Books(
        Integer id,
        String  name,
        Integer studentId
    ) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
    }

    /**
     * Getter for <code>users.books.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>users.books.id</code>.
     */
    public Books setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>users.books.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>users.books.name</code>.
     */
    public Books setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>users.books.student_id</code>.
     */
    public Integer getStudentId() {
        return this.studentId;
    }

    /**
     * Setter for <code>users.books.student_id</code>.
     */
    public Books setStudentId(Integer studentId) {
        this.studentId = studentId;
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
        final Books other = (Books) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (studentId == null) {
            if (other.studentId != null)
                return false;
        }
        else if (!studentId.equals(other.studentId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.studentId == null) ? 0 : this.studentId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Books (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(studentId);

        sb.append(")");
        return sb.toString();
    }
}