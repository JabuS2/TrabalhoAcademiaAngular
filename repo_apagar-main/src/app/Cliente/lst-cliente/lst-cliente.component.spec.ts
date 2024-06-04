import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LstClienteComponent } from './lst-cliente.component';

describe('LstClienteComponent', () => {
  let component: LstClienteComponent;
  let fixture: ComponentFixture<LstClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LstClienteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LstClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
