import { NgModule } from '@angular/core';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LayoutComponent } from './components/layout/layout.component';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
    imports: [
        NgbModule,
        RouterModule,
    ],
    exports: [NavbarComponent],
    declarations: [
        LayoutComponent,
        NavbarComponent,
    ],
    providers: [],
})
export class SharedModule { }
