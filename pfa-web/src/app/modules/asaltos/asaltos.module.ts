import { NgModule } from '@angular/core';
import { AsaltosComponent } from './components/asaltos/asaltos.component';
import { AsaltosRoutesModule } from './asaltos-routes.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';


@NgModule({
    imports: [
        AsaltosRoutesModule,
        RouterModule,
        SharedModule,
    ],
    exports: [AsaltosComponent],
    declarations: [AsaltosComponent],
    providers: [],
})
export class AsaltosModule { }
