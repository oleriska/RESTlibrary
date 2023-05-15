package lt.viko.eif.o.sharapova.library.controller;

import lt.viko.eif.o.sharapova.library.model.Library;
import lt.viko.eif.o.sharapova.library.service.LibraryService;
import lt.viko.eif.o.sharapova.library.utils.LibraryModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * REST controller that provides endpoints to resources related to {@link Library} class.
 */
@RestController
@RequestMapping(path = "/api/v1/libraries")
public class LibraryRestController {

    private final LibraryService libraryService;
    private final LibraryModelAssembler libraryModelAssembler;

    @Autowired
    public LibraryRestController(LibraryService libraryService, LibraryModelAssembler libraryModelAssembler) {
        this.libraryService = libraryService;
        this.libraryModelAssembler = libraryModelAssembler;
    }

    @GetMapping(path = "/getAllLibraries")
    public CollectionModel<EntityModel<Library>> getAllLibraries() {
        List<EntityModel<Library>> libraries = libraryService.getAllLibraries().stream()
                .map(libraryModelAssembler::toModel).toList();
        return CollectionModel.of(libraries, linkTo(methodOn(LibraryRestController.class).getAllLibraries()).withSelfRel());
    }

    @GetMapping(path = "/getLibraryByName/{name}")
    public EntityModel<Library> getLibraryByName(@PathVariable(name = "name") String name) {
        Library library = libraryService.getLibraryByName(name);
        return libraryModelAssembler.toModel(library);
    }

    @GetMapping(path = "/getLibrariesByBookTitle/{title}")
    public CollectionModel<EntityModel<Library>> getLibrariesByBookTitle(@PathVariable(name = "title") String title) {
        List<EntityModel<Library>> libraries = libraryService.getLibrariesByBook(title).stream().map(libraryModelAssembler::toModel).toList();
        return CollectionModel.of(libraries, linkTo(methodOn(LibraryRestController.class).getLibrariesByBookTitle(title)).withSelfRel());
    }


}
