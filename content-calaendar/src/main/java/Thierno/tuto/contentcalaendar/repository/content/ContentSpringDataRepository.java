package Thierno.tuto.contentcalaendar.repository.content;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import Thierno.tuto.contentcalaendar.model.content.Content;
import Thierno.tuto.contentcalaendar.model.content.ContentSpringData;

public interface ContentSpringDataRepository extends ListCrudRepository<ContentSpringData, Integer> {

  List<ContentSpringData> findAllByTitleContains(String keyword);

}
