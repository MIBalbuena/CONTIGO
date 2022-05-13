"use strict";

var model = (function() {

  // local storage 
  var data;

  if (localStorage.getItem('entryData')) {

    // Ultimo mensaje salvado
    data = JSON.parse(localStorage.getItem('entryData'));

  } else {

    
    // Local Storage: Vacio
    data = {
      users: [
        {
          email: "ava@gmail.com",
          password: "123456",
          name: "Ava Guerrero",
          profilePhoto: "somephoto.jpg"
        }
      ],
      entryList: [],
      entryIdCounter: 0,
      sortedStat: false,
      moodCounter: {
        happy: 0,
        sad: 0,
        neutral: 0,
        unsure: 0
      },
      moodPerc: {
        happy: 0,
        sad: 0,
        neutral: 0,
        unsure: 0
      }
    }

    
    // Local Storage: con datos
    localStorage.setItem('entryData', JSON.stringify(data));
  }
  


  class Entry {
    constructor(id, text, mood, timeStamp, favorited) {
      this.id = id;
      this.text = text;
      this.timeStamp = timeStamp;
      this.mood = mood;
      this.favorited = favorited;
    }

    deleteEntry() {

    }

    editEntry() {

    }

  }



  function calculateMoodPerc() {

    calculateIndMoodPerc("happy");
    calculateIndMoodPerc("sad");
    calculateIndMoodPerc("neutral");
    calculateIndMoodPerc("unsure");

  }



  function calculateIndMoodPerc(mood) {

    var totalMoodCount = data.moodCounter.happy + data.moodCounter.sad + data.moodCounter.neutral + data.moodCounter.unsure;

    

    data.moodPerc[mood] = Math.floor((data.moodCounter[mood] / totalMoodCount) * 100);

  }



  // Propiedades y Métodos -------------------------------------------
  return {

    getData: function() {
      return {
        data: data,
        sortedStat: data.sortedStat,
        entryList: data.entryList,
        moodPerc: data.moodPerc
      }
    },


    addEntry: function(text, mood) {

      var date = new Date();
      var dateString = moment().format('ddd, D MMMM YYYY, h:mm A');

      var timeStamp = dateString;
      var entryId = data.entryIdCounter++;
      var entry;
      var favorited = false;

      var newEntry = new Entry(entryId, text, mood, timeStamp, favorited);

      data.entryList.push(newEntry);

      return newEntry;

    },


    countUp: function(mood) {
      data.moodCounter[mood]++;
    },

    countDown: function(mood) {
      data.moodCounter[mood]--;
    },


    deleteEntry: function(id) {

      data.entryList.forEach(function(element, index) {
        
        if(element.id == id) {
          data.entryList.splice(index, 1);
        }

      });

    },



    moodCounter: function(mood, direction) {

      direction(mood);
      calculateMoodPerc();

    },



    getSortedMood: function(mood) {

      var entryListSorted = data.entryList.filter(function(element) {

        if(element.mood === mood) {
          return element;
        }

      });

      return entryListSorted;

    },


    testing: function() {
      console.log(data);
    }

  }

})();




/*
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
 */




var view = (function() {

  var domEl = {
    moodSelectorDOM: document.getElementById("moods"),
    inputEntryDOM: document.getElementById("input-diary"),
    entriesDOM: document.getElementById("entries"),
    entriesQDOM: document.querySelector("#entries"),
    meterHappyDOM: document.getElementById("meter-happy"),
    meterSadDOM: document.getElementById("meter-sad"),
    meterNeutralDOM: document.getElementById("meter-neutral"),
    meterUnsureDOM: document.getElementById("meter-unsure"),
    deleteEntryDOM: document.getElementsByClassName("delete"),
    moodSorterDOM: document.getElementById("mood-sorter"),
    moodSorterDateDOM: document.getElementById("mood-sorter-date"),
    emptyEntryDOM: document.getElementById("empty-entries"),
  }



  // Propiedades y Metodos -------------------------------------------
  return {

    // Elementos del DOM
    domEl: domEl,




    addEntry: function(entryList) {

      var html, newHtml;

      html = '<li class="entry %mood%-entry" id="%id%"><p>%text%</p><div class="overflow-hidden"><span class="timestamp">%timeStamp%</span><span class="delete">Delete</span><span class="favorite"></span></div></li>';

      newHtml = html.replace('%mood%', entryList.mood);
      newHtml = newHtml.replace('%id%', entryList.id);
      newHtml = newHtml.replace('%text%', entryList.text);
      newHtml = newHtml.replace('%timeStamp%', entryList.timeStamp);

      domEl.entriesDOM.insertAdjacentHTML('afterbegin', newHtml);

    },


    deleteEntry: function(entryId) {

      var el = document.getElementById(entryId);

      el.parentNode.removeChild(el);

    },


    displayEntries: function(entryList) {

      domEl.entriesDOM.innerHTML = "";

      entryList.forEach(function(entry) {

        var entryItemDOM = document.createElement("li");
        var entryTextDOM = document.createElement("p");
        var metaWrapperDOM = document.createElement("div");
        var timeStampDOM = document.createElement("span");
        var favoritedDOM = document.createElement("span");
        var deleteDOM = document.createElement("span");

        // Elemento de entrada y nombre de clase
        entryItemDOM.className = "entry";
        entryItemDOM.className += ` ${entry.mood}-entry`;
        entryItemDOM.id = entry.id;

        // Inserta la entrada hasta arriba del stack 
        domEl.entriesDOM.insertBefore(entryItemDOM, domEl.entriesDOM.firstChild);

        entryItemDOM.appendChild(entryTextDOM);
        entryTextDOM.innerHTML = entry.text;

        entryItemDOM.appendChild(metaWrapperDOM);
        metaWrapperDOM.className = "overflow-hidden";

        metaWrapperDOM.appendChild(timeStampDOM);
        timeStampDOM.className = "timestamp";
        timeStampDOM.innerHTML = entry.timeStamp;

        metaWrapperDOM.appendChild(deleteDOM);
        deleteDOM.className = "delete";
        deleteDOM.innerHTML = "Delete";    

        metaWrapperDOM.appendChild(favoritedDOM);
        favoritedDOM.className = "favorite";
      /*  favoritedDOM.innerHTML = "Favorite"; */   

      });

    },



    toggleDisplay: function(element, dispStatus) {
      element.style.display = dispStatus;
    },


    clearInput() {

      domEl.inputEntryDOM.value = "";

    },



    markSelectedMoodSort: function(e) {
      for (var i = 0; i < domEl.moodSorterDOM.children.length; i++) {
        domEl.moodSorterDOM.children[i].className = "";
      }
      e.target.className = "sort-selected";
    },



    handleError() {
      domEl.inputEntryDOM.focus();
      domEl.inputEntryDOM.style.borderColor = "#f16767";
    },

    clearError() {
      domEl.inputEntryDOM.style.borderColor = "#cde2f4";
    },




    updateMoodMeter: function(moodPerc) {

      domEl.meterHappyDOM.style.width = moodPerc.happy + "%";
      domEl.meterNeutralDOM.style.width = moodPerc.neutral + "%";
      domEl.meterSadDOM.style.width = moodPerc.sad + "%";
      domEl.meterUnsureDOM.style.width = moodPerc.unsure + "%";

    }



  }

})();




/*
-----------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------
 */




var controller = (function(viewC, modelC) {

  function initSetUp() {
    // Iniciar estatus
    viewC.displayEntries(modelC.getData().entryList);
    viewC.updateMoodMeter(modelC.getData().moodPerc);
    checkIfHaveEntry();

    // Controladores de Eventos
    viewC.domEl.moodSelectorDOM.addEventListener("click", addEntryCont);
    viewC.domEl.entriesQDOM.addEventListener("click", deleteEntryCont);
    viewC.domEl.moodSorterDOM.addEventListener("click", sortEntryCont);

  }



  function addEntryCont(e) {

    if(viewC.domEl.inputEntryDOM.value === "") {
      
      viewC.handleError();

    } else {

      viewC.clearError();

      // 1. Get input text (V) 
      var inputEntry = viewC.domEl.inputEntryDOM.value;
      

      // 1.1 Convert 'enter' to line breaks
      inputEntry = inputEntry.replace(/\r?\n/g, '<br />');

      // 2. Get selected mood (V) 
      var selectedMood = getSelectedMoodCont(e).slice(5);

      // 3. Add entry into the model (M)
      var newItem = modelC.addEntry(inputEntry, selectedMood);

      // 4. Update mood % data (M)
      modelC.moodCounter(selectedMood, modelC.countUp);

      // 5. Add entry into the UI (M)
      viewC.addEntry(newItem);

      // 6. Update mood % UI (V)
      viewC.updateMoodMeter(modelC.getData().moodPerc);

      // 7. Saves latest state into the local storage
      localStorage.setItem('entryData', JSON.stringify(modelC.getData().data));

      // 8. Clear input field (V)
      viewC.clearInput();

      // 9. Remove empty state
      checkIfHaveEntry();

    }

  }



  function deleteEntryCont(e) {

    // Funcion Borrar
    if(e.target.className === "delete") {

      var confirmDel = confirm("Are you sure you want to delete this entry?");

      if (confirmDel === true) {

        // Encontrar el ID a borrar

        // Para saber que metodo fue seleccionado y si se añade dinamicamente
        var itemID = e.target.parentNode.parentNode.id;
        var itemClass = e.target.parentNode.parentNode.className;
        var itemMood = itemClass.slice(6).slice(0, -6);

        // Borra datos
        modelC.deleteEntry(itemID);

        // CARITAS SEGUIMIENTO
        modelC.moodCounter(itemMood, modelC.countDown);

        
        viewC.updateMoodMeter(modelC.getData().moodPerc);

      
        viewC.deleteEntry(itemID);

       
        localStorage.setItem('entryData', JSON.stringify(modelC.getData().data));

     
        checkIfHaveEntry();

      } 

    }

  }



  function sortEntryDateCont(e) {



  }



  function sortEntryCont(e) {

    
    var selectedMoodSort = getSelectedMoodSortCont(e).slice(5);

    if(selectedMoodSort !== "sorter") {

      
      viewC.markSelectedMoodSort(e);

      if(selectedMoodSort === "all") {

      viewC.displayEntries(modelC.getData().entryList);

      } else {
        
        var sortedMood = modelC.getSortedMood(selectedMoodSort);

       
        viewC.displayEntries(sortedMood);
      }

    }

  }



  function getSelectedMoodCont(e) {

    return e.target.parentNode.id;

  }


  function getSelectedMoodSortCont(e) {

    return e.target.id;

  }


  function checkIfHaveEntry() {
    if(modelC.getData().entryList.length === 0) {
      viewC.toggleDisplay(viewC.domEl.emptyEntryDOM, "block");
    } else {
      viewC.toggleDisplay(viewC.domEl.emptyEntryDOM, "none");
    }
  }
  





  return {
    init: function() {
      console.log("App has started.");
      initSetUp();
    }
  }

  

 

})(view, model);


// Inicializar aplicación
controller.init();