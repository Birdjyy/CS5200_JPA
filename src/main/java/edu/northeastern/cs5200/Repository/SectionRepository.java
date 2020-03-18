package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface SectionRepository extends CrudRepository<Section, Integer> {
    @Query("select section from Section section")
    public List<Section> findAllSections();

    @Query("select section from Section section where section.course = :param")
    public List<Section> findSectionForCourse(@Param("param") Course course);
}
