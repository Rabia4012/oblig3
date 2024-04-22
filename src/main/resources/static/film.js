//Regex validering for telefonnummer.
let nummerRegex =/^\d{8}$/;

//Regex validering for e-post adresse.
let postRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

//Lager funksjonen LeggTilBillett.
function leggTilBillett() {
    //Samler alle verdiene fra input-boksene
    const billett = {
        antall: $("#antall").val(),
        film: $("#film").val(),
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        nummer: $("#nummer").val(),
        epost: $("#epost").val()
    };
    if (!nummerRegex.test(billett.nummer)) {
        alert("Du må taste inn et gyldig telefonnummer på 8 siffer.");
        return;
    }
    if (!postRegex.test(billett.epost)) {
        alert("Du må skrive inn en gyldig epost.");
        return;
    }

    $.post("/lagre", billett, function () {
        hentAlle()
    });

    antall:$("#antall").val("");
    film:$("#film").val("");
    fornavn:$("#fornavn").val("");
    etternavn:$("#etternavn").val("");
    nummer:$("#nummer").val("");
    epost:$("#epost").val("");
}
function hentAlle() {
    $.get("/hentAlle", function (billetter) {
        formaterData(billetter);
    });
}
function formaterData(billetter){
    let ut = "<table><tr><th>Antall</th><th>Film</th><th>Fornavn</th>" +
        "<th>Etternavn</th><th>Nummer</th><th>Epost</th></tr>";
    for (const billett of billetter) {
        ut += "<tr><td>" + billett.antall + "</td><td>" + billett.film + "</td><td>" + billett.fornavn + "</td>" +
            "<td>" + billett.etternavn + "</td><td>" + billett.nummer + "</td><td>" + billett.epost + "</td></tr>";
        ut += "</table>";
        $("#billettListe").html(ut);
    }
}
function slettAlle(){
    $.get("/slettAlle",function (){
        hentAlle();
    });
    $("#billettListe").html("");
}