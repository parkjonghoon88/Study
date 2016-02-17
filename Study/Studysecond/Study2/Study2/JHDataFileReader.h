//
//  JHDataFileReader.h
//  Study2
//
//  Created by 박종훈 on 2016. 2. 6..
//  Copyright © 2016년 박종훈. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "JHDataProvider.h"
#import "JHStudent.h"

@interface JHDataFileReader : NSObject<JHDataProvider>

- (instancetype) initWithFileName:(NSString*) fileName;

@end
