package com.example.android.reportcard;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Gavin on 6/30/2016.
 */
public class ReportCard {
    private final int mStudentID;
    private final int mYear;

    private String mStudentName;
    private ArrayList<String> mClassNames = new ArrayList<>();
    private ArrayList<Integer> mClassNumbers = new ArrayList<>();
    private ArrayList<String> mGrades = new ArrayList<>();

    // Constructor only needs student ID and year, which should not change.
    public ReportCard(int studentID, int year) {
        mStudentID = studentID;
        mYear = year;
    }

    /**
     * Fetches student name.
     *
     * @return student name
     */
    public String getStudentName() {
        return mStudentName;
    }

    /**
     *
     * @param mStudentName Name of student, which can change.
     */
    public void setStudentName(String mStudentName) {
        this.mStudentName = mStudentName;
    }

    /**
     *
     * @return ArrayList of class names for this report
     */
    public ArrayList<String> getClassNames() {
        return mClassNames;
    }

    /**
     *
     * @return ArrayList of course numbers for this report
     */
    public ArrayList<Integer> getClassNumbers() {
        return mClassNumbers;
    }

    /**
     *
     * @return simple text report card for this student with grades, course numbers and names
     */
    public String toString() {
        String grades = makeGradeTable();
        if (grades.isEmpty()) {
            grades = "No grades for this student!";
        }
        return String.format(Locale.getDefault(),
                "Student ID: %d-- %s\nGrade year: %d\n%s",
                mStudentID,
                mStudentName,
                mYear,
                grades);
    }

    /**
     * Adds a complete "grade entry" for a course to the report card list.
     *
     * @param classNumber of the course
     * @param className of the course
     * @param grade for the course
     */
    public void addGrade(int classNumber, String className, String grade) {
        mClassNumbers.add(classNumber);
        mClassNames.add(className);
        mGrades.add(grade);
    }

    /**
     * Remove a grade entry using the class number -- removes first occurrence of this course.
     * Multiple calls to this method required if the student received multiple grades for this course.
     *
     * @param classNumber of the grade to remove
     */
    public void removeGrade(int classNumber) {
        int index = mClassNumbers.indexOf(classNumber);
        mClassNames.remove(index);
        mGrades.remove(index);
        mClassNumbers.remove(index);
    }

    /**
     * Fetches all grades for this report card
     *
     * @return ArrayList of grades for this report card
     */
    public ArrayList<String> getmGrades() {
        return mGrades;
    }

    /**
     * Create a formatted String of all grades for this report card
     *
     * @return "tabulated" string of grades for this student's report card
     */
    private String makeGradeTable() {
        String gradeTable = "";
        for (int i = 0; i < mClassNumbers.size(); i++) {
            gradeTable += String.format(Locale.getDefault(),
                    "Class ID: %d -- %s Grade: %s\n",
                    mClassNumbers.get(i),
                    mClassNames.get(i),
                    mGrades.get(i));
        }
        return gradeTable;
    }
}
