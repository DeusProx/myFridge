import {Directive, AfterViewInit, OnChanges, ElementRef} from '@angular/core';

declare let componentHandler: any

@Directive({
    selector: '[mdl], [mdlUpgrade], [mdl-upgrade]'
})
export class MDL implements AfterViewInit {
    constructor(private elem: ElementRef){}
    ngAfterViewInit() {
        componentHandler.upgradeElement(this.elem.nativeElement)
    }
}