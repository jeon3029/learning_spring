package dev.taejjeon.calender.repository;

import dev.taejjeon.calender.model.Content;
import dev.taejjeon.calender.model.Status;
import dev.taejjeon.calender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
	private final List<Content> contentList = new ArrayList<>();

	public ContentCollectionRepository() {
	}
	public List<Content> findAll() {
		return contentList;
	}

	public Optional<Content> findById(Integer id){
		return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
	}

	@PostConstruct
	private void init(){
		Content c = new Content(1,
				"first blog post",
				"desc",
				Status.COMPLETED,
				Type.ARTICLE,
				LocalDateTime.of(2023,1,1,0,0),
				LocalDateTime.of(2023,1,1,0,0),"url"
				);
		contentList.add(c);
	}

	public void save(Content content) {
		contentList.removeIf(c->c.id().equals(content.id()));

		contentList.add(content);
	}

	public boolean existById(Integer id) {
		return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
	}

	public void delete(Integer id) {
		contentList.removeIf(c->c.id().equals(id));
	}
}
