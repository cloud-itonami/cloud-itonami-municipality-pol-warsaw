(ns culture.facts
  "Regional-culture catalog for Warsaw -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"warsaw"
   [{:culture/id "warsaw.dish.pierogi"
     :culture/name "Pierogi"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :dish
     :culture/summary "Filled dumplings of unleavened dough wrapped around a filling, originating in Poland and popular across Central and Eastern Europe; national rather than Warsaw-specific."
     :culture/url "https://en.wikipedia.org/wiki/Pierogi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "warsaw.dish.bigos"
     :culture/name "Bigos"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :dish
     :culture/summary "Polish dish of chopped meat of various kinds stewed with sauerkraut, shredded fresh cabbage and spices, considered a Polish national dish."
     :culture/url "https://en.wikipedia.org/wiki/Bigos"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "warsaw.dish.wuzetka"
     :culture/name "Wuzetka"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :dish
     :culture/summary "Chocolate sponge and cream pie that originated in Warsaw, likely named after the W-Z Route where the confectionery that first sold it was located in the late 1940s."
     :culture/url "https://en.wikipedia.org/wiki/Wuzetka"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "warsaw.product.ptasie-mleczko"
     :culture/name "Ptasie mleczko"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :product
     :culture/summary "Chocolate-covered soft-meringue confection ('bird's milk') first created in 1936 in Poland by Jan Wedel, owner of the E. Wedel company."
     :culture/url "https://en.wikipedia.org/wiki/Ptasie_mleczko"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "warsaw.product.e-wedel"
     :culture/name "E. Wedel chocolate"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :product
     :culture/summary "Confectionery from E. Wedel, a Polish confectionery company established in 1851 in Warsaw, where it remains headquartered today."
     :culture/url "https://en.wikipedia.org/wiki/E._Wedel"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "warsaw.beverage.zubrowka"
     :culture/name "Żubrówka"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :beverage
     :culture/summary "Flavored Polish vodka containing a blade of bison grass in every bottle; national rather than Warsaw-specific."
     :culture/url "https://en.wikipedia.org/wiki/%C5%BBubr%C3%B3wka"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "warsaw.festival.chopin-piano-competition"
     :culture/name "International Chopin Piano Competition"
     :culture/name-local "Międzynarodowy Konkurs Pianistyczny im. Fryderyka Chopina"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :festival
     :culture/summary "One of the most prestigious classical piano competitions, held in Warsaw first in 1927 and every five years since 1955."
     :culture/url "https://en.wikipedia.org/wiki/International_Chopin_Piano_Competition"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "warsaw.heritage.warsaw-old-town"
     :culture/name "Warsaw Old Town"
     :culture/name-local "Stare Miasto"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :heritage
     :culture/summary "Historic centre of Warsaw, a UNESCO World Heritage Site; its post-World War II rebuilding was the world's first attempt to resurrect an entire historic city core."
     :culture/url "https://en.wikipedia.org/wiki/Warsaw_Old_Town"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "warsaw.heritage.royal-castle"
     :culture/name "Royal Castle, Warsaw"
     :culture/name-local "Zamek Królewski w Warszawie"
     :culture/municipality "warsaw"
     :culture/country "POL"
     :culture/kind :heritage
     :culture/summary "State museum and national historical monument that formerly served as the official royal residence of several Polish monarchs; destroyed in World War II and meticulously reconstructed in 1971-1984."
     :culture/url "https://en.wikipedia.org/wiki/Royal_Castle,_Warsaw"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-pol-warsaw culture catalog "
                 "(ADR-2607171400): " (count (get catalog "warsaw"))
                 " Warsaw entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
