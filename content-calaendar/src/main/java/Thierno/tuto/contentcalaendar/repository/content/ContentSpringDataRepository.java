package Thierno.tuto.contentcalaendar.repository.content;

import org.springframework.data.repository.ListCrudRepository;

import Thierno.tuto.contentcalaendar.model.content.Content;
import Thierno.tuto.contentcalaendar.model.content.ContentSpringData;

public interface ContentSpringDataRepository extends ListCrudRepository<ContentSpringData, Integer> {}
