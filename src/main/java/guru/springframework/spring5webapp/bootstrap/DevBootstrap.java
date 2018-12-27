package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Author one = new Author();
        one.setFirstName("Juan");
        one.setLastName("Rulfo");

        Publisher publisherOne = new Publisher();
        publisherOne.setName("Anagrama");
        publisherOne.setAddres("Mexico");

        Book oneB = new Book();
        oneB.setIsbn("");
        oneB.setPublisher(publisherOne);
        oneB.setTitle("Pedro Paramo");

        publisherOne.setBook(oneB);
        one.getBooks().add(oneB);
        oneB.getAuthors().add(one);

        publisherRepository.save(publisherOne);
        authorRepository.save(one);
        bookRepository.save(oneB);
    }

}
