import java.util.ArrayList;
import java.util.List;

/**
 * Solution to exercise 13-7 from Cracking the Coding Interview, 6th edition.
 */
public class Population {

    // Class representing a country
    private class Country {

        // The continent this country belongs to
        private final String continent;
        // The name of this country
        private final String name;
        // The country's population
        private final int population;

        Country(String continent, String name, int population) {
            this.continent = continent;
            this.name = name;
            this.population = population;
        }

        String getContinent() {
            return this.continent;
        }

        String getName() {
            return this.name;
        }

        int getPopulation() {
            return this.population;
        }
    }

    /**
     * Computes the total population of the specified continent given the collection of countries.
     *
     * @param countries A list of countries to check against.
     * @param continent The continent to compute the population of.
     * @return The computed population.
     */
    public int getPopulation(List<Country> countries, String continent) {

        return countries.stream()
            .filter(c -> continent.equalsIgnoreCase(c.getContinent()))
            .mapToInt(c -> c.getPopulation())
            .sum();
    }

    public void start() {

        List<Country> countries = new ArrayList<>();

        countries.add( new Country("Africa", "Algeria", 34_000_000) );
        countries.add( new Country("Africa", "Egypt", 83_000_000) );
        countries.add( new Country("Africa", "Libya", 6_000_000) );
        countries.add( new Country("Africa", "Morocco", 36_000_000) );
        countries.add( new Country("Africa", "Kenya", 39_000_000) );
        countries.add( new Country("Africa", "Madagascar", 20_000_000) );
        countries.add( new Country("Africa", "Somalia", 10_000_000) );
        countries.add( new Country("Africa", "Sudan", 31_000_000) );
        countries.add( new Country("Africa", "Zimbabwe", 11_000_000) );

        countries.add( new Country("Asia", "China", 1_400_000_000) );
        countries.add( new Country("Asia", "Japan", 1_000_000) );
        countries.add( new Country("Asia", "Iraq", 38_000_000) );
        countries.add( new Country("Asia", "Iran", 80_000_000) );
        countries.add( new Country("Asia", "Kuwait", 4_000_000) );
        countries.add( new Country("Asia", "Malaysia", 30_000_000) );
        countries.add( new Country("Asia", "Russia", 145_000_000) );
        countries.add( new Country("Asia", "Taiwan", 24_000_000) );
        countries.add( new Country("Asia", "South Korea", 52_000_000) );

        countries.add( new Country("Europe", "Albania", 3_000_000) );
        countries.add( new Country("Europe", "Austria", 8_000_000) );
        countries.add( new Country("Europe", "Belgium", 11_000_000) );
        countries.add( new Country("Europe", "Denmark", 5_000_000) );
        countries.add( new Country("Europe", "France", 67_000_000) );
        countries.add( new Country("Europe", "Germany", 82_000_000) );
        countries.add( new Country("Europe", "Iceland", 350_000) );
        countries.add( new Country("Europe", "Norway", 5_000_000) );
        countries.add( new Country("Europe", "Spain", 46_000_000) );

        int population = getPopulation(countries, "Asia");
        System.out.printf("Population of Asia: %d\n", population);
        population = getPopulation(countries, "Africa");
        System.out.printf("Population of Africa: %d\n", population);
        population = getPopulation(countries, "Europe");
        System.out.printf("Population of Europe: %d\n", population);
    }

    public static void main(String[] args) {

        Population p = new Population();
        p.start();
    }
}
