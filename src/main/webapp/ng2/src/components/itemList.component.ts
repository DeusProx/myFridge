import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { Item } from 'src/models/item';
import { ItemService } from 'src/services/item.service';

@Component({
    selector: 'fridge-itemList',
    template: `
    <div class="mdl-grid">
        <div style="margin: auto; width: auto; min-height: auto;" class="demo-card-wide mdl-card mdl-shadow--2dp">
            <form [formGroup]="itemForm" (ngSubmit)="addItem()">
                <div (click)="this.insertItemIsOpen=!this.insertItemIsOpen" class="mdl-card__title">
                    <h2 class="mdl-card__title-text">Insert new item</h2>
                </div>

                <div [hidden]="!insertItemIsOpen" class="mdl-card__supporting-text mdl-card__actions mdl-card--border"  style="display:flex; flex-direction: row;">
                    <div style="display:flex; flex-direction: column;">
                        <span> Common Information: </span>
                        <div mdl class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input id="nameInput" formControlName="name" type="text" class="mdl-textfield__input"/>
                            <label for="nameInput" class="mdl-textfield__label">name<span *ngIf="itemForm.controls.name.errors">: required!</span></label>
                        </div>
                        <div mdl class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input id="bbdInput" formControlName="bbd" type="date" class="mdl-textfield__input" />
                            <label for="bbdInput" class="mdl-textfield__label">best-before date (DD.MM.YYYY)</label>
                        </div>
                        <div mdl class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input id="descriptionInput" formControlName="description" type="text" class="mdl-textfield__input"/>
                            <label for="descriptionInput" class="mdl-textfield__label">description</label>
                        </div>
                        <div mdl class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input id="ingredientsInput" formControlName="ingredients" type="text" class="mdl-textfield__input"/>
                            <label for="ingredientsInput" class="mdl-textfield__label">ingredients</label>
                        </div>
                    </div>
                    <fieldset formGroupName="nutritions">
                        <div style="display:flex; flex-direction: column;">
                            <span> Nutritional value (per 100gr): </span>
                            <div mdl class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input id="kcalInput" formControlName="kcal" type="number" class="mdl-textfield__input"/>
                                <label for="kcalInput" class="mdl-textfield__label">kcal</label>
                            </div>
                            <div mdl class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input id="proteinInput" formControlName="protein" type="number" class="mdl-textfield__input"/>
                                <label for="proteinInput" class="mdl-textfield__label">protein</label>
                            </div>
                            <div mdl class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input id="fatInput" formControlName="fat" type="number" class="mdl-textfield__input"/>
                                <label for="fatInput" class="mdl-textfield__label">fat</label>
                            </div>
                            <div mdl class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input id="carbohydratesInput" formControlName="carbohydrates" type="number" class="mdl-textfield__input"/>
                                <label for="carbohydratesInput" class="mdl-textfield__label">carbohydrates</label>
                            </div>
                        </div>
                    </fieldset>
                </div>
                <div [hidden]="!insertItemIsOpen" class="mdl-card__actions mdl-card--border" style="display:flex; flex-direction: column;">
                    <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" type="submit">
                        Add Item
                    </button>
                </div>
            </form>
        </div>
    </div>


    <div *ngIf="!items">
        <div style="position: fixed;top: 50%;left: 50%;transform: translate(-50%, -50%);">
            <div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner mdl-spinner--x3 is-active"></div>
        </div>
    </div>

    <div *ngIf="items" class="mdl-grid" style="display:flex; flex-direction: row;" style="margin:auto;">
        <div *ngIf="items.length == 0" class="demo-card-wide mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Items</h2>
            </div>
            <div class="mdl-card__supporting-text">
                <h2 > Fridge is Empty! First add items! </h2>
            </div>
        </div>

        <template [ngIf]="items.length > 0">
            <div *ngFor="let item of items" class="mdl-card mdl-shadow--2dp" style="margin: 8px 8px;">
                <div class="mdl-card__title">
                    <h2 class="mdl-card__title-text">{{item.name}}</h2>
                </div>
                <div class="mdl-card__supporting-text mdl-card__actions mdl-card--border" style="display:flex; flex-direction: column;">
                     <span>Common Information:</span>
                    <div class="mdl-card__supporting-text" style="display:flex; flex-direction: column;">
                        <span>id: {{item.id}}</span>
                        <span>owner: {{item.owner}}</span>
                        <span>best-before: {{item.bbd}}</span>
                        <span>description: {{item.description}}</span>
                        <span>ingredients: {{item.ingredients}}</span>
                    </div>
                    <span>Nutritional Value (100 gr):</span>
                    <div class="mdl-card__supporting-text" style="display:flex; flex-direction: column;">
                        <span>kcal: {{item.nutritions.kcal}} gr</span>
                        <span>protein: {{item.nutritions.protein}} gr</span>
                        <span>fat: {{item.nutritions.fat}} gr</span>
                        <span>carbohydrates: {{item.nutritions.carbohydrates}} gr</span>
                    </div>
                </div>
                  <div class="mdl-card__menu">
                    <button (click)="removeItem(item.id)" class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                        <i class="material-icons">clear</i>
                    </button>
                </div>
            </div>
        </template>
    </div>
    `,
    providers: [ ItemService ]
})
export class ItemListComponent {
    itemForm: FormGroup
    errorMessage: string
    items: Item[]
    insertItemIsOpen: boolean = false;

    constructor (private itemService: ItemService, fb:FormBuilder) {
        this.itemForm = fb.group({
            name: ['', Validators.required],
            bbd: [this.stringToday(), Validators.required],
            description: [''],
            ingredients: [''],
            nutritions: fb.group({
                kcal: [''],
                protein: [''],
                fat: [''],
                carbohydrates: ['']
            })
        })
    }

    ngOnInit() {
        this.getHeroes()
    }

    getHeroes() {
        this.itemService.getItems().subscribe(
            items => this.items = items,
            error => this.errorMessage = <any>error
        )
    }
    addItem() {
        if(!this.itemForm.valid) {
            console.log("Nah doesn't work")
            return
        }

        let newItem:Item = <Item>this.itemForm.value
        newItem.owner = localStorage.getItem("username")

        this.itemService.addItem(newItem).subscribe(
            boolean => {
                this.getHeroes()
                this.itemForm.reset({bbd: this.stringToday()})
                this.insertItemIsOpen = !this.insertItemIsOpen
            },
            error => this.errorMessage = <any>error
        )   
    }

    removeItem(id:number) {
        this.itemService.removeItem(id).subscribe (
            boolean => this.getHeroes(),
            error => this.errorMessage = <any>error
        )
    }
    private stringToday():String {
        let today = new Date();
        let stringToday = "" + today.getFullYear() + "-"

        if(today.getMonth()<9) stringToday += "0"
        stringToday += (today.getMonth()+1) + "-"

        if(today.getDate() < 10) stringToday += "0"
        stringToday +=  today.getDate()

        return stringToday;
    }
}