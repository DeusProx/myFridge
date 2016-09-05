import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {enableProdMode} from '@angular/core';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';

import {AppModule} from 'src/app.module';

enableProdMode();

const platform = platformBrowserDynamic()
platform.bootstrapModule(AppModule);