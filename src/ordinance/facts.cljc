(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Warsaw -- the
  TWENTY-NINTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi for the first twenty-eight) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation).

  isap.sejm.gov.pl (Poland's primary national legal-act database) is
  CAPTCHA-gated site-wide -- not attempted further, per this project's
  standing rule to never solve/bypass CAPTCHAs. bip.warszawa.pl,
  um.warszawa.pl, and transport.um.warszawa.pl all returned HTTP 403;
  edziennik.mazowieckie.pl (the regional official gazette, where
  Warsaw council resolutions are formally published) timed out on
  three separate document URLs; warszawa19115.pl refused the
  connection outright.

  Both entries here instead cite two domains that DID render cleanly:

  - Ustawa z dnia 15 marca 2002 r. o ustroju miasta stołecznego
    Warszawy (Act of 15 March 2002 on the System of the Capital City
    of Warsaw) -- a Kancelaria Sejmu (Sejm Chancellery)-published
    consolidated-text PDF mirrored on up.warszawa.pl, directly
    confirmed by reading the rendered cover page (title, Dziennik
    Ustaw citation Dz.U. 2002 Nr 41 poz. 361, and Art. 1's own text
    establishing Warsaw's status as a city with powiat rights, all
    legible).
  - Uchwała Nr XXXIX/1587/2026 Rady m.st. Warszawy (a 2 July 2026
    Warsaw City Council resolution naming a primary school) --
    directly confirmed via eto.um.warszawa.pl's own resolution-detail
    page, which states the resolution number, full title, and
    adoption date in full.

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"warsaw"
   [{:ordinance/id "warsaw.ustawa-ustroj-warszawy-2002"
     :ordinance/title "Ustawa z dnia 15 marca 2002 r. o ustroju miasta stołecznego Warszawy"
     :ordinance/municipality "warsaw"
     :ordinance/country "POL"
     :ordinance/kind :local-act
     :ordinance/number "Dz.U. 2002 Nr 41 poz. 361"
     :ordinance/url "https://www.up.warszawa.pl/prawo/ustroj230511.pdf"
     :ordinance/url-provenance :official-kancelaria-sejmu-mirror
     :ordinance/enacted-date "2002-03-15"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}
    {:ordinance/id "warsaw.uchwala-xxxix-1587-2026"
     :ordinance/title "Uchwała Nr XXXIX/1587/2026 Rady m.st. Warszawy (naming of Primary School No. 396)"
     :ordinance/municipality "warsaw"
     :ordinance/country "POL"
     :ordinance/kind :ordinance
     :ordinance/number "Uchwała Nr XXXIX/1587/2026"
     :ordinance/url "https://eto.um.warszawa.pl/category/215/announcement/156845"
     :ordinance/url-provenance :official-eto-um-warszawa-pl
     :ordinance/enacted-date "2026-07-02"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}]})

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
      :note (str "cloud-itonami-municipality-pol-warsaw Wave 0 (ADR-2607141700): "
                 (count (get catalog "warsaw")) " Warsaw entries seeded "
                 "with official Kancelaria Sejmu/eto.um.warszawa.pl citations. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
