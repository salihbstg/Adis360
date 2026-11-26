```mermaid
flowchart TD

    front[FRONTEND]
<-->
    back[BACKEND]
<-->
    postgres[POSTGRESQL]

    back
<-->
    media[MEDIA SERVICE]

subgraph BACKEND
    dentity[Identity]
end
