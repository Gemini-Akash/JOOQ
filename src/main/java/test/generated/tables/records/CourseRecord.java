/*
 * This file is generated by jOOQ.
 */
package test.generated.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import test.generated.tables.Course;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CourseRecord extends UpdatableRecordImpl<CourseRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>users.course.course_id</code>.
     */
    public CourseRecord setCourseId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>users.course.course_id</code>.
     */
    public String getCourseId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>users.course.description</code>.
     */
    public CourseRecord setDescription(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>users.course.description</code>.
     */
    public String getDescription() {
        return (String) get(1);
    }

    /**
     * Setter for <code>users.course.title</code>.
     */
    public CourseRecord setTitle(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>users.course.title</code>.
     */
    public String getTitle() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Course.COURSE.COURSE_ID;
    }

    @Override
    public Field<String> field2() {
        return Course.COURSE.DESCRIPTION;
    }

    @Override
    public Field<String> field3() {
        return Course.COURSE.TITLE;
    }

    @Override
    public String component1() {
        return getCourseId();
    }

    @Override
    public String component2() {
        return getDescription();
    }

    @Override
    public String component3() {
        return getTitle();
    }

    @Override
    public String value1() {
        return getCourseId();
    }

    @Override
    public String value2() {
        return getDescription();
    }

    @Override
    public String value3() {
        return getTitle();
    }

    @Override
    public CourseRecord value1(String value) {
        setCourseId(value);
        return this;
    }

    @Override
    public CourseRecord value2(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public CourseRecord value3(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public CourseRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CourseRecord
     */
    public CourseRecord() {
        super(Course.COURSE);
    }

    /**
     * Create a detached, initialised CourseRecord
     */
    public CourseRecord(String courseId, String description, String title) {
        super(Course.COURSE);

        setCourseId(courseId);
        setDescription(description);
        setTitle(title);
    }
}
