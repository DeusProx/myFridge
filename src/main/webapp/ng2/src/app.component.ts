import { Component, ViewChild } from '@angular/core'
import { Router } from '@angular/router';

declare let componentHandler: any;

@Component({
  selector: 'fridge-app',
  template:
  `
  <dialog mdl #userConfigDialog class="mdl-dialog">
    <h4 class="mdl-dialog__title">User Settings</h4>
    <div class="mdl-dialog__content">
      <p> Choose your username. It will be saved when you put items into the fridge. For testing purposes you can always change your username! </p>
      <div class="mdl-textfield mdl-js-textfield">
        <input class="mdl-textfield__input" type="text" #usernameInput>
      </div>
    </div>
    <div class="mdl-dialog__actions">
      <button type="button" class="mdl-button" (click)="closeDialog()" >OK</button>
    </div>
  </dialog>

  <div class="demo-layout mdl-layout mdl-layout--fixed-header mdl-js-layout mdl-color--grey-100">
    <!-- Header -->
    <header class="demo-header mdl-layout__header mdl-layout__header--scroll mdl-color--grey-100 mdl-color-text--grey-800">
      <div class="mdl-layout__header-row">
        <span class="mdl-layout-title">myFridge</span>
        <img src="favicon.ico" style="margin: 8px">
        <!--<button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" (click)="router.navigate(['/fridge'])">Fridge</button>-->
        <!--<button
            class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect"
            (click)="router.navigate(['/items/new'])">
            Add Item
        </button>-->
        <div class="mdl-layout-spacer"></div>
        <!--<div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable" style="padding-top: 27px">
          <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
            <i class="material-icons">search</i>
          </label>
          <div class="mdl-textfield__expandable-holder">
            <input class="mdl-textfield__input" type="text" id="search">
            <label class="mdl-textfield__label" for="search">Enter your query...</label>
          </div>
        </div>-->
        <!-- FAB button -->
        <!-- Icon button -->
        <button class="mdl-button mdl-js-button mdl-button--icon" (click)="openDialog()">
          <i class="material-icons">settings</i>
        </button>

      </div>
    </header>

    <!-- Drawer -->
    <!--<div class="mdl-layout__drawer mdl-color--grey-100 mdl-color-text--grey-800">
      <span class="mdl-layout-title">Discussify - Delete?</span>
    </div>-->

    <!-- Content -->
    <main class="mdl-layout__content">
      <router-outlet></router-outlet>
    </main>

    <footer class="mdl-mini-footer">
    </footer>

  </div>
  `
})
export class AppComponent {
  @ViewChild('userConfigDialog') userConfigDialog:any;
  @ViewChild('usernameInput') usernameInput:any;
  constructor() {
  }
  //to use pure mdl we need to upgrade the dom
  ngAfterViewInit() {
    componentHandler.upgradeDom()
    /* DEBUG for some browser
    let dialog : any = this.userConfigDialog.nativeElement;
    if (!dialog.showModal) {
      dialog.registerDialog(dialog);
    }*/
  }
  openDialog () {
    this.usernameInput.nativeElement.value = localStorage.getItem("username")
    this.userConfigDialog.nativeElement.showModal();
  }
  closeDialog () {
    localStorage.setItem("username", this.usernameInput.nativeElement.value)
    this.userConfigDialog.nativeElement.close()
  }
}
