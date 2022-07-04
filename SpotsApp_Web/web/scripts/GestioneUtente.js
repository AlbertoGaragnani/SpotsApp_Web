function parsificaJSON( jsonText ) {


		var item = JSON.parse(jsonText);
		risultato = "";
		risultato += item;	

		
	// ciclo di lettura degli elementi
	//for (    var a = 0, b = item.length;    a < b;   a++   ) {
		//risultato += '<li>' + item[a].nome+', ('+item[a].x+','+item[a].y+'), '+ item[a].nome+ ", " +item[a].descrizione +'</li>';	
	//}
    return risultato;
}

function callback( theXhr, element ) {

	
	// verifica dello stato
	if ( theXhr.readyState === 2 ) {
	}// if 2
	else if ( theXhr.readyState === 3 ) {
	}// if 3
	else if ( theXhr.readyState === 4 ) {
		// verifica della risposta da parte del server
		if ( theXhr.status === 200 ) {
			// operazione avvenuta con successo
			var item = JSON.parse(theXhr.responseText);
			window.location = item;
			
		}// if 200

		 else {
	        	// errore di caricamento
	        }// else (if ! 200)
	}// if 4

}

function requestInterestIframe() {
    // qui faccio scaricare al browser direttamente il contenuto del feed come src dell'iframe.
    Alert("Impossibile effettuare l'operazione, il tuo browser è troppo vecchio")

    // non riesco tuttavia a intervenire per parsificarlo! è il browser che renderizza il src del iframe!
}

function requestAJAX(xhr, val, idSpot) {
    // impostazione controllo e stato della richiesta
    // xhr.onreadystatechange = function() { callback(xhr); };
    // impostazione richiesta asincrona in GET
    // del file specificato
    try {
        xhr.open("get", "gestioneUtente?operazione="+val+"&idSpot="+idSpot, true);
    }
    catch(e) {
        // Exceptions are raised when trying to access cross-domain URIs
        alert(e);
    }
    // rimozione dell'header "connection" come "keep alive"
    xhr.setRequestHeader("connection", "close");
    // invio richiesta
    xhr.send(null);
} 



 

function visualizzaSpot(myB)
{
    var xhr = myGetXmlHttpRequest();
    var val=myB.value;
    var idSpot = myB.id;

    if ( xhr ) 
        requestAJAX(xhr, val, idSpot);
    else 
        requestInterestIframe();
}

function aggiungiSpot(myB)
{
    var xhr = myGetXmlHttpRequest();
    var val=myB.value;
    var idSpot = "";

    if ( xhr ) 
        requestAJAX(xhr, val, idSpot);
    else 
        requestInterestIframe();
}

function visualizzaProfilo(myB)
{
    var xhr = myGetXmlHttpRequest();
    var val=myB.value;
    var idSpot = "";

    if ( xhr ) 
        requestAJAX(xhr, val, idSpot);
    else 
        requestInterestIframe();
}

function logout(myB)
{
    var xhr = myGetXmlHttpRequest();
    var val=myB.value;
    var idSpot = "";

    if ( xhr ) 
        requestAJAX2(xhr, val, idSpot);
    else 
        requestInterestIframe();
}
