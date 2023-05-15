package lt.viko.eif.o.sharapova.library.utils;

import lt.viko.eif.o.sharapova.library.controller.LibraryRestController;
import lt.viko.eif.o.sharapova.library.model.Library;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Model assembler provided by Spring HATEOAS that defines methods to convert plain
 * {@link Library} objects into {@link EntityModel<Library>} instances.
 */
@Component
public class LibraryModelAssembler implements RepresentationModelAssembler<Library, EntityModel<Library>> {

    @Override
    public EntityModel<Library> toModel(Library library) {
        return EntityModel.of(library,
                linkTo(methodOn(LibraryRestController.class).getLibraryByName(library.getName())).withSelfRel(),
                linkTo(methodOn(LibraryRestController.class).getAllLibraries()).withRel("all_libraries"));
    }

}
