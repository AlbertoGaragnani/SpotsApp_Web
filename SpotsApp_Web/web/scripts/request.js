function parsificaJSON( jsonText ) {

		var item = JSON.parse(jsonText);

		//itemNodes = new Array(),

		var risultato = "";
		
		risultato+= item;
		
		
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
			
			element.innerHTML = parsificaJSON(theXhr.responseText);
			
		}// if 200

		 else {
	        	// errore di caricamento
	        	element.innerHTML = "Impossibile effettuare l'operazione richiesta.<br />";
	        	element.innerHTML += "Errore riscontrato: " + theXhr.statusText;
	        }// else (if ! 200)
	}// if 4

}

function requestInterestIframe() {
	// qui faccio scaricare al browser direttamente il contenuto del feed come src dell'iframe.
	Alert("Impossibile effettuare l'operazione, il tuo browser è troppo vecchio")
	
	// non riesco tuttavia a intervenire per parsificarlo! è il browser che renderizza il src del iframe!
}

function requestAJAX(xhr, element, val) {
	// impostazione controllo e stato della richiesta
	xhr.onreadystatechange = function() { callback(xhr, element); };
	// impostazione richiesta asincrona in GET
	// del file specificato
	try {
		xhr.open("get", "Server?val="+val, true);
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

function myFunction(element, myF)
{
	var xhr = myGetXmlHttpRequest();
	var val=myF.value;
	//var val=document.getElementById("text").value;         esempio con document.getElementById()
	
	//var val=document.getElementById('c').value;
	//var val=myGetElementById('c').value;
	if ( xhr ) 
		requestAJAX(xhr, element, val);
	else 
		requestInterestIframe();
}