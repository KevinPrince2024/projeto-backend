package br.edu.ifsp.graphql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.exceptions.NotFound;
import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.service.DroidService;
import br.edu.ifsp.graphql.service.HumanService;
import br.edu.ifsp.graphql.service.StarshipService;

@Controller
public class StarWarController {
    private final DroidService droidService;
    private final HumanService humanService;
    private final StarshipService starshipService;

    public StarWarController(DroidService ds, HumanService hs, StarshipService ss) {
        this.droidService = ds;
        this.humanService = hs;
        this.starshipService = ss;
    }

    /*
     * Mapeado no resources/graphql/scheme.graphqls 
     * 
     * type Query {
     *     hero(episode: Episode): Character
     * }
     */
    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return new Droid(
                "2001", 
                "R2-D2", 
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI), 
                List.of(),
                "Astromech"
        );
    }

    /*
     * Mapeado no resources/graphql/scheme.graphqls 
     * 
     * type Query {
     *     droid(id: ID!): Droid
     * }
     */
    @QueryMapping
    public Droid droid(@Argument String id) {
        return new Droid(
            id, 
            "R2-D2",
            List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
            List.of(), 
            "Astromech"
        );
    }

    /*
     * Mapeado no resources/graphql/scheme.graphqls 
     * 
     * type Query {
     *      search(text: String!): [SearchResult!]!
     * }
     */
    @QueryMapping
    public List<Object> search(@Argument String text) {
        return List.of(
                new Droid("2001", "R2-D2", List.of(), List.of(), "Astromech"),
                new Human("1001", "Luke", List.of(), List.of(), 1.72f),
                new Starship("3001", "Millenium Falcon", 1000));
    }

    @QueryMapping
    public List<Human> findAllHumans() {
        return this.humanService.findAll();
    }

    @QueryMapping
    public List<Starship> findAllStarships() {
        return this.starshipService.findAll();
    }

    @QueryMapping
    public Optional<Human> findCharacterById(@Argument String id) throws NotFound {
        return this.humanService.findById(id);
    }

    /*
     * Mapeado no resources/graphql/scheme.graphqls 
     * 
     *  type Mutation {
     *      createReview(episode: Episode!, review: ReviewInput!): Review
     *  }
     */
    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return new Review(review.getStars(), review.getCommentary());
    }

    @MutationMapping
    public Human createHuman(Human human) {
        return this.humanService.save(human);
    }

    @MutationMapping
    public Droid createDroid(Droid droid) {
        return this.droidService.save(droid);
    }

    @MutationMapping
    public Starship createStarship(Starship starship) {
        return this.starshipService.save(starship);
    }

    @MutationMapping
    public Character addFriend(String characterId, String friendId) {
        return this.createHuman(null);
    }

}
