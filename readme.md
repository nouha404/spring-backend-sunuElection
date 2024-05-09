Documentation de l’API

Base URL :
```
http://localhost:8000/api
```

Endpoint:

Lister les candidats avec la possibilité de filtrer par prénom

GET  /candidats : Renvoie l'ensemble des candidats à l'élection présidentielle

Response : Renvoie un objet JSON contenant un tableau d'objets candidat. Chaque candidat a les propriétés suivantes :
- nom : Nom du candidat
- prenom : Prénom du candidat
- profession : Profession du candidat
- partie_politique : Parti politique du candidat
- programme_file_path : Chemin vers le programme en PDF du candidat
- description : Description du candidat
- photo_path : Chemin vers la photo du candidat
- statuts : Code de statut de la requête

Exemple d’utilisation
Request:

```
http://localhost:8000/api/candidats
```

Response:
```json
    {
  "totalItems": 19,
  "pages": [
    0,
    0,
    0,
    0
  ],
  "PreviousPage": 0,
  "nextPage": 1,
  "totalPages": 4,
  "currentPage": 0,
  "statuts": 200,
  "results": [
    {
      "id": 1,
      "isActive": true,
      "nom": "Camara",
      "prenom": "Boubacar",
      "profession": "Douanier/Avocat",
      "partiePolitique": "PCS-Jengu Tabax",
      "photoPath": "https://github.com/nouha404/image-and-pdf/blob/main/photos/Boubacar-camara.png",
      "programmeFilePath": "https://www.editions-harmattan.fr/catalogue/couv/aplat/9782140317583.pdf",
      "description": "Boubacar Camara, né le 26 juin 1958 à Dakar, a débuté sa carrière dans la Marine nationale sénégalaise après avoir été formé à l’École nationale de Formation maritime de Dakar. Il a poursuivi ses études en droit, obtenant un doctorat de l’Université Pierre Mendès France de Grenoble, axé sur le contentieux douanier au Sénégal, et a complété sa formation à l’École de Formation du Barreau à Paris.\n\n                    Sa carrière au sein de la Douane sénégalaise a été marquée par une progression rapide, culminant avec sa nomination en tant que Directeur général des Douanes en mai 2000. Dans ce rôle, il a initié des réformes visant à moderniser l’administration douanière.\n\n                    Après avoir quitté la Douane, Camara s’est orienté vers le conseil, apportant son expertise en douane et commerce international à divers pays africains. Il a également pratiqué le droit à la Cour d’appel de Paris. En 2009, il a été nommé Secrétaire général du Ministère de la Coopération internationale, des Transports aériens, des Infrastructures et de l’Énergie du Sénégal, et en 2011, il est devenu Président du Conseil d’administration de Sénégal Airlines.\n\n                    En 2012, Camara a fondé un cabinet de consultation, se concentrant sur des projets dans l’énergie solaire, les hydrocarbures, et le partenariat public-privé. Il a pris sa retraite anticipée de l’Inspection générale d’État en juin 2015, concluant ainsi sa carrière dans le service public."
    },
    {
      "id": 2,
      "isActive": true,
      "nom": "Dieye",
      "prenom": "Cheikh Tidiane",
      "profession": "Docteur en sociologie",
      "partiePolitique": "PCS-Jengu Tabax",
      "photoPath": "https://github.com/nouha404/image-and-pdf/blob/main/photos/CHEIKH-TIDIANE-DIEYE.png",
      "programmeFilePath": null,
      "description": "Cheikh Tidiane DIEYE, originaire de Ziguinchor, est détenteur d’une Maîtrise en sociologie du développement de l’Université Gaston Berger de Saint-Louis et d’un Doctorat en études du développement de l’Institut des Hautes Etudes Internationales et du Développement (IHEID) à Genève, Suisse.\n\n                    Sa carrière débute au Centre International pour le Commerce et le Développement Durable (ICTSD) à Genève, avant de rejoindre Enda Tiers-Monde à Dakar en 2002, où il coordonne les programmes sur le commerce et les négociations commerciales internationales. En 2012, il fonde le Centre Africain pour le Commerce, l’Intégration et le Développement (CACID), devenant un expert reconnu en politiques commerciales et d’intégration en Afrique.\n\n                    Engagé dans la promotion de la bonne gouvernance et de l’État de droit en Afrique, DIEYE a participé activement à diverses initiatives citoyennes et politiques. Il a été membre du Conseil d’Administration du Forum Civil, co-initiateur de plateformes citoyennes pour la participation des candidats indépendants aux élections, et a joué un rôle clé dans des mouvements pour la transparence dans la gestion des ressources naturelles. Sa contribution au débat public inclut des ouvrages sur la corruption et les relations Afrique-Europe. DIEYE se présente comme candidat à l’élection présidentielle du 25 février 2024, marquant une étape importante dans son parcours politique et citoyen."
    },
    {
      "id": 3,
      "isActive": true,
      "nom": "Dethie",
      "prenom": "Fall",
      "profession": "Ingénieur Polytechnicien",
      "partiePolitique": "MBA",
      "photoPath": "https://github.com/nouha404/image-and-pdf/blob/main/photos/Dethie-fall.png",
      "programmeFilePath": "http://news.adakar.com/documents/docs/Dethie-Fall.pdf",
      "description": "Déthié Fall, originaire de Saint-Louis, est un ingénieur polytechnicien avec un Master in Business Administration (MBA), spécialisé dans la gestion de projets complexes et stratégiques. Il a également suivi une formation d’officier de réserve à l’École Nationale des Officiers d’Active (ENOA) de Thiès.\n\n                    Sur le plan politique, son parcours a débuté par un rapprochement avec Idrissa Seck, président du parti Rewmi, en 2004. Il a joué un rôle actif dans la création de ce parti, devenant président des cadres en 2011, puis cumulant les fonctions de président des cadres et directeur des structures en 2013. De 2014 à 2018, il a été vice-président de Rewmi, tout en conservant ses précédentes responsabilités. Entre 2018 et 2020, il a occupé le poste de vice-président de Rewmi et a été le numéro 2 de Idrissa Seck lors de l’élection présidentielle de 2019.\n\n                    En 2021, Déthié Fall a pris la présidence du Parti Républicain pour le Progrès (PRP). Il a également été actif au sein de l’opposition, coordonnant les plénipotentiaires de GOR ÇA WAX DJA en 2016 pour les concertations sur le processus électoral et ceux de l’opposition pour le dialogue politique de 2019-2020. Depuis 2021, il est le mandataire national de la coalition d’opposition Yewwi Askan Wi et a été le concepteur du Plan Déthié Fall (PDF) pour les législatives de 2022, une stratégie d’exécution pour l’inter coalition Yewwi Askan Wi-Wallu Sénégal."
    },
    {
      "id": 4,
      "isActive": true,
      "nom": "Ndiaye",
      "prenom": "Daouda",
      "profession": "Professeur Titulaire des Universités",
      "partiePolitique": "FC DAOUDA",
      "photoPath": "https://github.com/nouha404/image-and-pdf/blob/main/photos/Daouda-Ndiaye.png",
      "programmeFilePath": "https://www.ipar.sn/IMG/pdf/pogramme_du_candidat_daouda_ndiaye.pdf",
      "description": "Le Pr. Daouda Ndiaye est un éminent parasitologue et mycologue sénégalais. Fort de son agrégation en Parasitologie et Mycologie décernée par le CAMES (Conseil Africain et Malgache pour l’Enseignement Supérieur), il détient le titre de Professeur Titulaire des Universités de Classe Exceptionnelle.\n\n                    Il est le fondateur et Directeur Général du Centre International de Recherche et de Formation en Génomique Appliquée et de Surveillance Sanitaire (CIGASS), une institution dédiée à la recherche et à l’innovation en santé.\n\n                    Au sein de l’Université Cheikh Anta Diop de Dakar (UCAD), le Pr. Daouda Ndiaye occupe plusieurs fonctions, dont celle de Chef du Service de Parasitologie-Mycologie Pharmaceutique à la Faculté de Médecine, de Pharmacie et d’Odontologie (FMPO). Il est également à la tête du Service de Parasitologie et Mycologie au Centre hospitalier universitaire Aristide le Dantec de Dakar.\n\n                    Il est Professeur chercheur associé à l’Université Harvard de Boston aux États-Unis, ce qui témoigne de sa reconnaissance internationale dans le domaine de la recherche médicale.\n\n                    Le Pr. Daouda Ndiaye a reçu diverses distinctions pour son expertise, dont le Prix de la francophonie 2020 de l’Académie Française de Pharmacie. En 2022, il a été élevé au rang de Professeur Émérite de Médecine Tropicale Américaine par la Société Savante Américaine de Médecine Tropicale et d’Hygiène, marquant ainsi son impact significatif dans la médecine tropicale."
    },
    {
      "id": 5,
      "isActive": true,
      "nom": "Habib",
      "prenom": "Sy",
      "profession": "Economiste",
      "partiePolitique": "FC ECONOMIE",
      "photoPath": "https://github.com/nouha404/image-and-pdf/blob/main/photos/Habib-Sy.png",
      "programmeFilePath": null,
      "description": "Habib Sy est un économiste et homme politique sénégalais, originaire de Linguère. Sa carrière est marquée par une contribution significative à la fois dans l’administration publique et dans l’arène politique du Sénégal.\n\n                    Sur le plan professionnel, Habib Sy a débuté sa carrière en tant que commissaire aux Enquêtes économiques principales, après avoir obtenu son brevet de l’ENAM. Son expertise en économie l’a conduit à occuper des postes clés, reflétant son engagement envers le développement économique et la gestion efficace des ressources.\n\n                    Politiquement, Sy a eu un parcours remarquable. Il a été directeur de cabinet de Me Abdoulaye Wade entre mars 1995 et mars 1997, avant de devenir ministre d’État dans plusieurs gouvernements. Il a notamment servi en tant que ministre des Infrastructures, des Transports terrestres et des Transports aériens, ainsi que ministre de la Fonction publique, de l’Emploi, du Travail et des Organisations professionnelles. En outre, il a été maire de Linguère de 2002 à 2014, démontrant son engagement envers le service public et le développement local."
    }
  ]
}

```

Lister le candidat a la presidentielle dont le nom = Diao
Requete :
```json
http://localhost:10002/api/candidats?nom=Diao
```
Response:

```json
{
  "totalItems": 1,
  "pages": [
    0
  ],
  "PreviousPage": 0,
  "nextPage": 0,
  "totalPages": 1,
  "currentPage": 0,
  "statuts": 200,
  "results": [
    {
      "id": 17,
      "isActive": true,
      "nom": "Diao",
      "prenom": "El Hadji Mamadou",
      "profession": "Inspecteur des impots",
      "partiePolitique": "APS",
      "photoPath": "https://github.com/nouha404/image-and-pdf/blob/main/photos/Mame-boye-diao.png",
      "programmeFilePath": "https://www.ipar.sn/IMG/pdf/programme_mama_boye_diao.pdf",
      "description": "Elhadj Mamadou Diao, plus connu sous le nom de Mameboye, est né en 1970 à Bignona. Mameboye a débuté ses études à l’école Abdoulaye Diallo de Doumassou avant de poursuivre au Lycée Alpha Molo Baldé de Kolda, où il a obtenu son baccalauréat en 1991.\n\n                    Après le lycée, Mameboye a intégré l’Université Gaston Berger à Saint-Louis, où il a décroché une maîtrise en Sciences politiques, option Relations internationales, en 1996. Il a ensuite réussi le concours de l’École Nationale d’Administration (ENA) de Dakar en 1998, devenant inspecteur des impôts et des domaines en 2000.\n\n                    Sa carrière professionnelle a commencé au Centre des Services Fiscaux de Dakar-Plateau, où il a travaillé de 2000 à 2005, avant de devenir chef de centre à Fatick puis aux Parcelles Assainies. En 2014, il a été promu Directeur des Services Fiscaux régionaux, et en 2017, Directeur des Services à la Direction générale des Impôts et Domaines.\n\n                    En politique, Mameboye a rejoint l’Alliance Pour la République (APR) du Président Macky Sall en 2012.  Le 23 janvier 2022, il a été élu maire de Kolda sous la bannière de la Coalition CPJE/Nay Leer.\n\n                    Mameboye est marié à Adja Amélie Diadhiou et père de trois enfants."
    }
  ]
}
```


Lister le nombre d’électeurs inscrits sur la liste électorale

GET /electeurs/nombre-inscrits : Renvoie le nombre total d'électeurs inscrits sur la liste électorale

Response : Renvoie un objet JSON contenant le nombre total d'électeurs inscrits

Exemple d’utilisation
Request:
```
http://localhost:10002/api/electeurs/nombre-inscrits
```

Response:
```json
{
  "statuts": 200,
  "results": 29
}
```


Lister les électeurs qui ont voté avec possibilité de filtrer via le numéro CNI spécifié

GET /electeurs/voter/informations : Renvoie les électeurs qui ont voté avec le numéro CNI spécifié

Response : Renvoie un objet JSON contenant les détails des électeurs qui ont voté avec le numéro CNI spécifié

Exemple d’utilisation
Request:

```json
http://localhost:10002/api/electeurs/voter/informations
```

Response:

```json
{
  "totalItems": 9,
  "pages": [
    0
  ],
  "PreviousPage": 0,
  "nextPage": 0,
  "totalPages": 1,
  "currentPage": 0,
  "statuts": 200,
  "results": [
    {
      "nom": "Karla",
      "prenom": "Kulas",
      "telephone": "580.767.6245",
      "numeroElecteur": "CNI010153",
      "numeroCni": "1268927"
    },
    {
      "nom": "Marlin",
      "prenom": "Buckridge",
      "telephone": "(829) 243-3043",
      "numeroElecteur": "CNI027089",
      "numeroCni": "2296280"
    },
    {
      "nom": "Irving",
      "prenom": "Sporer",
      "telephone": "1-787-286-2116",
      "numeroElecteur": "CNI039744",
      "numeroCni": "3874570"
    },
    {
      "nom": "Burl",
      "prenom": "Beatty",
      "telephone": "936-020-2011",
      "numeroElecteur": "CNI046512",
      "numeroCni": "4330997"
    },
    {
      "nom": "Dave",
      "prenom": "Schiller",
      "telephone": "937-928-6564",
      "numeroElecteur": "CNI054416",
      "numeroCni": "5389933"
    },
    {
      "nom": "Hassie",
      "prenom": "Mills",
      "telephone": "878.576.9635",
      "numeroElecteur": "CNI067537",
      "numeroCni": "6700399"
    },
    {
      "nom": "Pierre",
      "prenom": "Bartell",
      "telephone": "038.707.5008",
      "numeroElecteur": "CNI071529",
      "numeroCni": "7942123"
    },
    {
      "nom": "Thresa",
      "prenom": "Romaguera",
      "telephone": "(088) 972-0065",
      "numeroElecteur": "CNI089915",
      "numeroCni": "8918882"
    },
    {
      "nom": "Annett",
      "prenom": "Blanda",
      "telephone": "(822) 142-7012",
      "numeroElecteur": "CNI099024",
      "numeroCni": "9718011"
    }
  ]
}

```

Le lister l'electeur qui a voter dont son CNI = 1268927
Request:
```json
http://localhost:10002/api/electeurs/voter/informations?CNI=9718011
```
Response:
```json
{
  "totalItems": 1,
  "pages": [
    0
  ],
  "PreviousPage": 0,
  "nextPage": 0,
  "totalPages": 1,
  "currentPage": 0,
  "statuts": 200,
  "results": [
    {
      "nom": "Annett",
      "prenom": "Blanda",
      "telephone": "(822) 142-7012",
      "numeroElecteur": "CNI099024",
      "numeroCni": "9718011"
    }
  ]
}
```





Lister le nombre total d'électeurs qui ont voté

GET /electeurs/voter : Renvoie le nombre total d'électeurs ayant voté

Response : Renvoie un objet JSON contenant le nombre total d'électeurs ayant voté

Exemple d’utilisation
Request:
```json
http://localhost:10002/api/electeurs/voter
```
Response:

```json
{
  "statuts": 200,
  "results": 9
}
```


Faire voter un electeur

POST electeurs/voter/numeroCni

Request:
```json
http://localhost:10002/api/electeurs/voter/11686377
```
Response:
```json
Vote ajouté avec succès
```
J'ai proceder ainsi car j'ai une erreur 403 je veux generer un token d'authentification