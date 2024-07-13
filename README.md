### Project clonen: https://blog.jetbrains.com/idea/2020/10/clone-a-project-from-github/
### I.P.V. een url kun je beter via github clonen. Dit staat onder 'repository url'. Dan kun je hem hier selecteren nadat je de uitnodiging in de mail hebt geaccepteerd.

### 2. Dataset download links.
* Item 1
   * https://service.pdok.nl/lv/bag/atom/bag.xml (bovenste van 7gb)

### 3. Open Source Routing System


### 4. Vervolg stappen
1. installeer docker.
2. cd documents
3. mkdir OSRM-KBSb

4. docker pull ghcr.io/project-osrm/osrm-backend:v5.27.1


5. wget http://download.geofabrik.de/europe/netherlands-latest.osm.pbf
    Voor Windows even opzoeken hoe je wget moet downloaden. Ik heb geen verstand van windows.
    
    Voor macOS -> brew install wget. Daarna kun je die stap 1 verder uitvoeren.

6. docker run -t -v "${PWD}:/data" ghcr.io/project-osrm/osrm-backend osrm-extract -p /opt/car.lua /data/netherlands-latest.osm.pbf || echo "osrm-extract failed"


7. docker run -t -v "${PWD}:/data" ghcr.io/project-osrm/osrm-backend osrm-partition /data/netherlands-latest.osrm || echo "osrm-partition failed"
8. docker run -t -v "${PWD}:/data" ghcr.io/project-osrm/osrm-backend osrm-customize /data/netherlands-latest.osrm || echo "osrm-customize failed"


9. docker run -t -i -p 5000:5000 -v "${PWD}:/data" ghcr.io/project-osrm/osrm-backend osrm-routed --algorithm mld /data/netherlands-latest.osrm

10. Voor meer info: https://github.com/Project-OSRM/osrm-backend

