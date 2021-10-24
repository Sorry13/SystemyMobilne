//
//  AppDelegate.h
//  2Zadanie
//
//  Created by student on 19/10/2021.
//  Copyright © 2021 aplikacja. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreData/CoreData.h>

@interface AppDelegate : UIResponder <UIApplicationDelegate>

@property (readonly, strong) NSPersistentContainer *persistentContainer;

- (void)saveContext;


@end

