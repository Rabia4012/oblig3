//Regex validering for telefonnummer.
let nummerRegex =/^[0-9]{8}$/;

//Regex validering for e-post adresse.
let postRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

//Lager funksjonen LeggTilBillett.
function leggTilBillett() {

    //Lager billett objektet
    const billett = {
        antall: $("#antall").val(),
        film: $("#film").val(),
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        nummer: $("#nummer").val(),
        epost: $("#epost").val()
    };
    //Regex validering for telefonnummer
    if (!nummerRegex.test(billett.nummer)) {
        alert("Du må taste inn et gyldig telefonnummer på 8 siffer.");
        return;
    }
    //Regex validering for epost adresse
    if (!postRegex.test(billett.epost)) {
        alert("Du må skrive inn en gyldig epost.");
        return;
    }

    //Kaller post-kallet som skal lagre billetten
    $.post("/lagre", billett, function () {
        hentAlle()
    });

    //Tømmer input-felt
    antall:$("#antall").val("");
    film:$("#film").val("");
    fornavn:$("#fornavn").val("");
    etternavn:$("#etternavn").val("");
    nummer:$("#nummer").val("");
    epost:$("#epost").val("");
}


function hentAlle() {
    //Kaller hentAlle-kallet som skal hente billettene
    $.get("/hentAlle", function (billetter) {
        formaterData(billetter);
    });
}


//Lager tabell for å få skrevet ut billettene.
function formaterData(billetter){
    let ut = "<table class='table table-striped'>"+
        "<tr>" +
        "<td>Antall</td><td>Film</td><td>Fornavn</td><td>Etternavn</td><td>Nummer</td><td>Epost</td>"+
        "</tr>";
    //Skriver ut billettene med en for løkke.
    for (const billett of billetter) {
        ut += "<tr>" +
            "<td>" + billett.antall +
            "</td><td>" + billett.film +
            "</td><td>" + billett.fornavn +
            "</td>" +
            "<td>" + billett.etternavn + "</td><td>" + billett.nummer + "</td><td>" + billett.epost + "</td>" +
            "</tr>";
    }
    ut += "</table>";
    //Skriver ut løkken til billettlisten
    $("#billettListe").html(ut);
}



//Kaller get-kallet for sletting av alle billetter
function slettAlle(){
    $.get("/slettAlle",function (){
        hentAlle();
    });
    //Tømmer listen ved å sette html-verdien til ingenting
    $("#billettListe").html("");
}