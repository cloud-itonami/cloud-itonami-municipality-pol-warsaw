# cloud-itonami-municipality-pol-warsaw

Municipal-ordinance compliance catalog for **Warsaw** — the
TWENTY-NINTH municipality-level entry alongside
[`cloud-itonami-municipality-jpn-tokyo`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-tokyo),
[`cloud-itonami-municipality-usa-washington-dc`](https://github.com/cloud-itonami/cloud-itonami-municipality-usa-washington-dc),
[`cloud-itonami-municipality-gbr-london`](https://github.com/cloud-itonami/cloud-itonami-municipality-gbr-london),
[`cloud-itonami-municipality-can-toronto`](https://github.com/cloud-itonami/cloud-itonami-municipality-can-toronto),
[`cloud-itonami-municipality-deu-berlin`](https://github.com/cloud-itonami/cloud-itonami-municipality-deu-berlin),
[`cloud-itonami-municipality-fra-paris`](https://github.com/cloud-itonami/cloud-itonami-municipality-fra-paris),
[`cloud-itonami-municipality-nld-amsterdam`](https://github.com/cloud-itonami/cloud-itonami-municipality-nld-amsterdam),
[`cloud-itonami-municipality-esp-madrid`](https://github.com/cloud-itonami/cloud-itonami-municipality-esp-madrid),
[`cloud-itonami-municipality-kor-seoul`](https://github.com/cloud-itonami/cloud-itonami-municipality-kor-seoul),
[`cloud-itonami-municipality-ita-roma`](https://github.com/cloud-itonami/cloud-itonami-municipality-ita-roma),
[`cloud-itonami-municipality-aus-sydney`](https://github.com/cloud-itonami/cloud-itonami-municipality-aus-sydney),
[`cloud-itonami-municipality-arg-buenos-aires`](https://github.com/cloud-itonami/cloud-itonami-municipality-arg-buenos-aires),
[`cloud-itonami-municipality-fin-helsinki`](https://github.com/cloud-itonami/cloud-itonami-municipality-fin-helsinki),
[`cloud-itonami-municipality-dnk-copenhagen`](https://github.com/cloud-itonami/cloud-itonami-municipality-dnk-copenhagen),
[`cloud-itonami-municipality-nor-oslo`](https://github.com/cloud-itonami/cloud-itonami-municipality-nor-oslo),
[`cloud-itonami-municipality-bel-brussels`](https://github.com/cloud-itonami/cloud-itonami-municipality-bel-brussels),
[`cloud-itonami-municipality-chl-santiago`](https://github.com/cloud-itonami/cloud-itonami-municipality-chl-santiago),
[`cloud-itonami-municipality-col-bogota`](https://github.com/cloud-itonami/cloud-itonami-municipality-col-bogota),
[`cloud-itonami-municipality-cri-san-jose`](https://github.com/cloud-itonami/cloud-itonami-municipality-cri-san-jose),
[`cloud-itonami-municipality-bra-sao-paulo`](https://github.com/cloud-itonami/cloud-itonami-municipality-bra-sao-paulo),
[`cloud-itonami-municipality-ury-montevideo`](https://github.com/cloud-itonami/cloud-itonami-municipality-ury-montevideo),
[`cloud-itonami-municipality-zaf-cape-town`](https://github.com/cloud-itonami/cloud-itonami-municipality-zaf-cape-town),
[`cloud-itonami-municipality-ecu-quito`](https://github.com/cloud-itonami/cloud-itonami-municipality-ecu-quito),
[`cloud-itonami-municipality-swe-gothenburg`](https://github.com/cloud-itonami/cloud-itonami-municipality-swe-gothenburg),
[`cloud-itonami-municipality-pry-asuncion`](https://github.com/cloud-itonami/cloud-itonami-municipality-pry-asuncion),
[`cloud-itonami-municipality-mex-guadalajara`](https://github.com/cloud-itonami/cloud-itonami-municipality-mex-guadalajara),
[`cloud-itonami-municipality-fra-lyon`](https://github.com/cloud-itonami/cloud-itonami-municipality-fra-lyon),
and
[`cloud-itonami-municipality-ind-new-delhi`](https://github.com/cloud-itonami/cloud-itonami-municipality-ind-new-delhi).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

Warsaw is the axis's first Central/Eastern European entry.

## Sourcing note

`isap.sejm.gov.pl` (Poland's primary national legal-act database) is
CAPTCHA-gated site-wide — not attempted further, per this project's
standing rule to never solve/bypass CAPTCHAs. `bip.warszawa.pl`,
`um.warszawa.pl`, and `transport.um.warszawa.pl` all returned HTTP
403; `edziennik.mazowieckie.pl` (the regional official gazette) timed
out on three separate document URLs; `warszawa19115.pl` refused the
connection outright. Both entries here instead cite two domains that
DID render cleanly: a Kancelaria Sejmu (Sejm Chancellery)-published
consolidated-text PDF mirrored on `up.warszawa.pl`, and
`eto.um.warszawa.pl`'s own council-resolution bulletin board.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the City of
Warsaw's behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljk` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries directly confirmed: **Ustawa z dnia 15 marca 2002 r. o
ustroju miasta stołecznego Warszawy** (Act of 15 March 2002 on the
System of the Capital City of Warsaw, Dz.U. 2002 Nr 41 poz. 361) and
**Uchwała Nr XXXIX/1587/2026 Rady m.st. Warszawy** (a 2 July 2026
Warsaw City Council resolution).

## Culture catalog

Alongside the ordinance catalog, this repo carries a **regional-culture
catalog** (ADR-2607171400, `cloud-itonami-municipality-culture-catalog`
in `com-junkawasaki/root`) — local dishes, protected products, beverages,
festivals and heritage sites for Warsaw:

- `src/culture/facts.cljk` — the catalog, source of truth.
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

Same provenance discipline as the ordinance catalog: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Ordinance text
itself remains the City of Warsaw's; this repo stores only citation
metadata (id/title/url/dates), not full text.
